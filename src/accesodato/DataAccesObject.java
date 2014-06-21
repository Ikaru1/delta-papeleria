/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDato;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;


import org.hibernate.classic.Session;

/**
 *
 * @author vehimar
 */
public class DataAccesObject {

    private HibernateUtil hibernate;

    public DataAccesObject() {
        hibernate = new HibernateUtil();
    }

    public void insertarObject(Object objeto) {
        Transaction transaction = null;
        try {
            Session session = (Session) hibernate.currentSession();
            transaction = session.beginTransaction();
            transaction.begin();
            session.persist(objeto);
            transaction.commit();
            hibernate.closeSession();
        } catch (HibernateException e) {
            transaction.rollback();
        }
    }

    public Object getObject(String sql) {
        Transaction transaction = null;
        List lista = null;
        try {
            Session session = (Session) hibernate.currentSession();
            transaction = session.beginTransaction();
            transaction.begin();
            lista = session.find(sql);
            transaction.commit();
            hibernate.closeSession();
        } catch (Exception e) {
            transaction.rollback();
        }
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }

    public List<Object> listaObject(String sql) {
        Transaction transaction = null;
        List lista = null;
        try {
            Session session = (Session) hibernate.currentSession();
            transaction = session.beginTransaction();
            transaction.begin();
            lista = session.find(sql);
            transaction.commit();
            hibernate.closeSession();
        } catch (Exception e) {
            transaction.rollback();
            return null;
        }
        return lista;
    }

    public void modificarObject(Object object) {
        Transaction transaction = null;
        try {
            Session session = (Session) hibernate.currentSession();
            session = (Session) hibernate.currentSession();
            transaction = session.beginTransaction();
            transaction.begin();
            session.update(object);
            transaction.commit();
            hibernate.closeSession();
        } catch (HibernateException e) {
            transaction.rollback();
        }
    }

    public void eliminarObject(Object object) {
        Transaction transaction = null;
        try {
            Session session = (Session) hibernate.currentSession();
            session = (Session) hibernate.currentSession();
            transaction = session.beginTransaction();
            transaction.begin();
            session.delete(object);
            transaction.commit();
            hibernate.closeSession();
        } catch (HibernateException e) {
            transaction.rollback();
        }
    }

    public List<Object> listarObject(String Tabla) {
        Transaction transaction = null;
        List result = null;
        String sentencia = "from " + Tabla;
        try {
            Session session = (Session) hibernate.currentSession();
            session = (Session) hibernate.currentSession();
            transaction = session.beginTransaction();
            result = session.find(sentencia);
            transaction.commit();
            hibernate.closeSession();
        } catch (HibernateException e) {
            transaction.rollback();
            return null;
        }
        return result;
    }
}
