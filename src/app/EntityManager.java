package app;

import Entities.Usuarios.Usuario;
import Util.LogHandler;
import jakarta.persistence.Entity;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.logging.Level;

public class EntityManager {
    public EntityManager() {

    }

    private Entity find(Class<?> classname, int id) {
        Entity entity = null;

        try {
            Session session = App.db.getSessionFactory().openSession();

            entity = (Entity) session.find(classname, id);

        } catch (HibernateException e) {
            LogHandler.log(Level.SEVERE, e.getMessage());
        }

        return entity;
    }

    private List<Entity> selectWhere(Class<?> classname, String criteria) {
        List<Entity> entities = null;

        try {
            Session session = App.db.getSessionFactory().openSession();

            Table table = classname.getAnnotation(Table.class);
            String tableName = table.name();
            String hql = "FROM "+tableName+" d " + criteria;
            Query query = session.createQuery(hql);

            entities = query.getResultList();

        } catch (HibernateException e) {
            LogHandler.log(Level.SEVERE, e.getMessage());
        }

        return entities;
    }

    private Entity save(Entity entity) {

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

    private boolean remove(Entity entity) {
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
