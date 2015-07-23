package com.lumiplan.hibernate.DAO;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import com.lumiplan.hibernate.utility.HibernateUtil;

public class DAO {
	
	private static final ThreadLocal THREAD = new ThreadLocal();
	 
    protected DAO() {
    }
 
    public static Session getSession() {
        Session session = (Session) DAO.THREAD.get();
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
            DAO.THREAD.set(session);
            getSession().setFlushMode(FlushMode.COMMIT);
        }
        return session;
    }
 
    protected static void begin() {
        getSession().beginTransaction();
    }
 
    protected static void commit() {
        getSession().getTransaction().commit();
    }
 
    protected static void rollback() {
        getSession().getTransaction().rollback();
        getSession().close();
        DAO.THREAD.set(null);
    }
 
    protected static void flush() {
        getSession().flush();
    }
 
    protected static void close() {
        getSession().close();
        DAO.THREAD.set(null);
    }

}
