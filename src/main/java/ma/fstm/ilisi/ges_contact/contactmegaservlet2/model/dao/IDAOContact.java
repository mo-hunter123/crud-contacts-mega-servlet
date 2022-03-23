package ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.dao;

import ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.bo.Contact;

import java.util.List;

public interface IDAOContact {
    public boolean inserer(Contact c);
    boolean deleteById(int id);
    boolean delete(Contact c);
    boolean update(Contact contact);
    Contact findByID(int id);
    List<Contact> getAll();
}