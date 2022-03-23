package ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    public static SessionFactory sessionFactory;
    public static SessionFactory getsessionFactory()
    {
        if(sessionFactory==null)
        {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }catch(Throwable e){
                System.out.println("Error in connecting");
                System.out.println(e.getMessage());
                sessionFactory=null;
            }
        }
        return sessionFactory;
    }
}
