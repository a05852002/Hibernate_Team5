package tw.hibernatedemo.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SessionFactoryListener implements ServletContextListener {
<<<<<<< HEAD

	public SessionFactoryListener() {
		// TODO Auto-generated constructor stub
	}

	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.closeSessionFactory();
		System.out.println("Create SeesionFactory!!");
	}

	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory();
		System.out.println("SeesionFactory Closed!!");
	}

=======
    public SessionFactoryListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	HibernateUtil.closeSessionFactory();
    	System.out.println("SessionFactory Closed!!");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	HibernateUtil.getSessionFactory();
    	System.out.println("Create SessionFactory!!!");
    }
	
>>>>>>> 042643b74810b2c9d09d3bea67d399e98d9e9d7f
}
