package app;

import Util.LogHandler;
import jakarta.persistence.Entity;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.logging.Level;

public class EntityManager {
    public EntityManager() {

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
    public List<Object> select_old(Class<?> classname, String criteria, Object[]... parameters) {
        List<Object> entities = null;

        try {
            Session session = App.db.getSessionFactory().openSession();

            Table table = classname.getAnnotation(Table.class);
            String tableName = table.name();
            String hql = "FROM "+tableName+" d " + criteria;
            Query query = session.createQuery(hql);

            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i, parameters[i]);
            }

            entities = query.getResultList();

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
    public Entity selectOne_old(Class<?> classname, String criteria, Object[]... parameters) {
        Entity entity = null;

        try {
            Session session = App.db.getSessionFactory().openSession();

            Table table = classname.getAnnotation(Table.class);
            String tableName = table.name();
            String hql = "FROM "+tableName+" d " + criteria;
            Query query = session.createQuery(hql);

            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i, parameters[i]);
            }

            entity = (Entity) query.getSingleResult();

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
    public List<Object> select(Class<?> classname, String criteria, Object[]... parameters) {
        List<Object> entities = null;

        try {
            Session session = App.db.getSessionFactory().openSession();

            session.beginTransaction();

            Table table = classname.getAnnotation(Table.class);
            String tableName = table.name();
            Query query = session.createNativeQuery("SELECT * FROM "+tableName + " " + criteria, classname);

            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i, parameters[i]);
            }

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
            Query query = (Query) session.createNativeQuery("SELECT * FROM "+tableName + " " + criteria, classname).getResultStream()
                    .findFirst()
                    .orElse(null);

            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i+1, parameters[i]);
            }

            try {
                entity = query.getSingleResult();
            } catch (NoResultException e) {
                entity = false;
            }

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

            session.persist(entity);

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
    private boolean remove(Object entity) {
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
}
