package ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.dao;

import ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.bo.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DAOContact implements IDAOContact{
    @Override
    public boolean inserer(Contact c) {
        SessionFactory sessionFactory=HibernateUtil.getsessionFactory();
        Session session=sessionFactory.openSession();
        //Type type=c.getType();

        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(c);
            //Type type=session.load(Type.class, c.getType().getId());
            session.flush();
            tx.commit();
            return true;
        }
        catch(Exception exp) {
            tx.rollback();
            return false;
        }

    }

    @Override
    public boolean delete(Contact c) {
        SessionFactory sessionFactory = HibernateUtil.getsessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction = session.beginTransaction();
            session.remove(c);
            transaction.commit();

            return true;
        }catch (Exception e){
            transaction.rollback();
            System.out.println("Error in deletion: "+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {

        SessionFactory sessionFactory=HibernateUtil.getsessionFactory();
        Session session=sessionFactory.openSession();
        //Type type=c.getType();

        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Contact c=new Contact();
            c.setId(id);
            session.delete(c);
            session.flush();
            tx.commit();
            return true;

        }catch(Exception exp) {
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean update(Contact contact) {

        SessionFactory sessionFactory=HibernateUtil.getsessionFactory();
        Session session=sessionFactory.openSession();

        Transaction tx = session.getTransaction();
        try {
            tx=session.beginTransaction();

            session.update(contact);
            session.flush();
            tx.commit();
            return true;

        }catch(Exception exp) {
            tx.rollback();
            System.out.println("Error in update"+exp.getMessage());
            return false;
        }
    }

    @Override
    public Contact findByID(int id) {

        SessionFactory sessionFactory=HibernateUtil.getsessionFactory();
        Session session=sessionFactory.openSession();

        return session.load(Contact.class, id);
    }

    @Override
    public List<Contact> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getsessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try
        {
            transaction = session.beginTransaction();

            List<Contact> contacts = session.createQuery("from Contact").list();
            System.out.println(contacts);
            transaction.commit();
            return contacts;
        }catch (Exception e){
            System.out.println("Hibernate ERr: "+e);
            transaction.rollback();
            return null;
        }
    }

}
