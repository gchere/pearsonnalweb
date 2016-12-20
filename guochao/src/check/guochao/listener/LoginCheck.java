package check.guochao.listener;

import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Application Lifecycle Listener implementation class LoginCheck
 *
 */
@WebListener
public class LoginCheck implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
	private ServletContext app = null;
    /**
     * Default constructor. 
     */
    public LoginCheck() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void contextInitialized(ServletContextEvent pt)  { 
    	app = pt.getServletContext();
    	app.setAttribute("online", new TreeSet());
    }
    public void sessionCreated(HttpSessionEvent pst)  { 
       
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent pst)  { 
    	 Set all = (Set)app.getAttribute("online");
         all.remove(pst.getSession().getAttribute("userid"));
         app.setAttribute("online", all);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent paramServletContextEvent)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent pt)  { 
    	 Set all = (Set)app.getAttribute("online");
         all.add(pt.getValue());
         app.setAttribute("online", all);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent pt)  { 
    	 Set all = (Set)app.getAttribute("online");
         all.remove(pt.getValue());
         app.setAttribute("online", all);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent paramHttpSessionBindingEvent)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
	
}
