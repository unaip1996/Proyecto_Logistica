package app;

import Util.LogHandler;
import Util.SerializableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class EntityManager {

    public static final int ROWS_PER_PAGE = 7;
    public EntityManager() {

    }


    public int getTableCount(Class<?> classname) {
        Integer count = 0;

        try {
            Session session = App.db.getSessionFactory().openSession();

            Table table = classname.getAnnotation(Table.class);
            String tableName = table.name();
            Query query = (Query) session.createNativeQuery("SELECT COUNT(id) FROM "+tableName, Integer.class);

            count = (Integer) query.getSingleResult();

        } catch (HibernateException e) {
            LogHandler.log(Level.SEVERE, e.getMessage());
        }

        return count;
    }

    /**
     * Devuelve un objeto de entidad que tenga el id proporcionado en la tabla de BD
     *
     * @param classname Literal de clase de la entidad (Ej.: Usuario.class)
     * @param id id de BD
     * @return Entity
     */
    public Entity find(Class<?> classname, int id) {
        Entity entity = null;

        try {
            Session session = App.db.getSessionFactory().openSession();

            entity = (Entity) session.find(classname, id);

        } catch (HibernateException e) {
            LogHandler.log(Level.SEVERE, e.getMessage());
        }

        return entity;
    }

    /**
     * Devuelve una lista de objetos de entidad que cumplan los requerimientos de la consulta
     *
     * @param classname Literal de clase de la entidad (Ej.: Usuario.class)
     * @param criteria String de query adyacente a la select, si está vacía hará SELECT *
     * @param parameters Array de parámetros opcional, en el caso de usarse, los parámetros de criteria deberán llamarse ?<<int>> empezando por 0 y en orden
     * @return List<Entity>
     */
    public List<Object> select(Class<?> classname, int pageNumber, String criteria, Object[]... parameters) {
        List<Object> entities = null;

        try {
            Session session = App.db.getSessionFactory().openSession();

            session.beginTransaction();

            Table table = classname.getAnnotation(Table.class);
            String tableName = table.name();
            Query query = session.createNativeQuery("SELECT * FROM "+tableName + " " + criteria, classname);

            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i+1, parameters[i]);
            }
            query.setFirstResult(pageNumber * ROWS_PER_PAGE);
            query.setMaxResults(ROWS_PER_PAGE);

            entities = query.getResultList();

            session.close();

        } catch (HibernateException e) {
            LogHandler.log(Level.SEVERE, e.getMessage());
        }

        return entities;
    }


    /**
     * Devuelve un objeto de entidad que cumpla los requerimientos de la consulta
     *
     * @param classname Literal de clase de la entidad (Ej.: Usuario.class)
     * @param criteria String de query adyacente a la select, si está vacía hará SELECT *
     * @return List<Entity>
     */
    public Object selectOne(Class<?> classname, String criteria, String[] parameters) {
        Object entity = null;

        try {
            Session session = App.db.getSessionFactory().openSession();

            Table table = classname.getAnnotation(Table.class);
            String tableName = table.name();
            Query query = (Query) session.createNativeQuery("SELECT * FROM "+tableName + " " + criteria, classname);

            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i+1, parameters[i]);
            }

            entity = query.getResultStream()
                    .findFirst()
                    .orElse(null);

        } catch (HibernateException e) {
            LogHandler.log(Level.SEVERE, e.getMessage());
        }

        return entity;
    }

    /**
     * Guardar entidad, sirve para crear y actualizar
     *
     * @param entity Entidad de Hibernate
     * @return Entity
     */
    public Object save(Object entity) {

        try {
            Session session = App.db.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(entity.getClass().getName(), entity);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            LogHandler.log(Level.SEVERE, e.getMessage());
        }

        return entity;
    }

    /**
     * Eliminar entidad, elimina el registro de base de datos
     *
     * @param entity Entidad de Hibernate
     * @return boolean
     */
    public boolean remove(Object entity) {
        boolean removed = false;


        try {
            Session session = App.db.getSessionFactory().openSession();

            session.beginTransaction();

            session.remove(entity);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            LogHandler.log(Level.SEVERE, e.getMessage());
        }

        return removed;
    }

    public <T extends SerializableEntity> boolean removeNative(Class<?> classname, List<T> items) {
        boolean removed = false;


        try {
            if (!items.isEmpty()) {
                Session session = App.db.getSessionFactory().openSession();

                session.beginTransaction();

                Table table = classname.getAnnotation(Table.class);
                String tableName = table.name();
                Query query = (Query) session.createNativeQuery("DELETE FROM "+tableName + " WHERE id IN(:ids)", classname);

                List<Integer> ids = new ArrayList<>();
                for (T item : items) {
                    ids.add(item.getId());
                }
                query.setParameter("ids", ids);
                query.executeUpdate();

                session.getTransaction().commit();
            }
        } catch (HibernateException e) {
            LogHandler.log(Level.SEVERE, e.getMessage());
        }

        return removed;
    }
    public boolean executeNativeQuery(String sqlQuery, String[] parameters) {
        boolean executed = false;


        try {
            Session session = App.db.getSessionFactory().openSession();

            session.beginTransaction();

            Query query = (Query) session.createNativeQuery(sqlQuery);

            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i+1, parameters[i]);
            }

            query.executeUpdate();

            session.getTransaction().commit();
        } catch (HibernateException e) {
            LogHandler.log(Level.SEVERE, e.getMessage());
        }

        return executed;
    }
}
