package ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.sevice;

import ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.bo.Contact;
import ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.dao.DAOContact;
import ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.dao.IDAOContact;

public class ContactValidator {
    IDAOContact contactIDAO;
    public ContactValidator() {
        this.contactIDAO = new DAOContact();
    }

    public boolean validateContact(Contact c) {
        boolean status = true ;
        if(c.getAdresse().isEmpty() || c.getNom().isEmpty() || c.getTelephone().isEmpty())
            status = false;
        else {
            if(c.getTelephone().length() != 13 || !c.getTelephone().startsWith("+212"))
                status = false;
        }
        if(status == true){
            status = contactIDAO.inserer(c);
        }
        return status;
    }

    public boolean deleteContact(Contact c){
        boolean stat = contactIDAO.delete(c);

        return stat;
    }

    public boolean updateContact(Contact c){
        boolean status = true ;
        if(c.getAdresse().isEmpty() || c.getNom().isEmpty() || c.getTelephone().isEmpty())
            status = false;
        else {
            if(c.getTelephone().length() != 13 || !c.getTelephone().startsWith("+212"))
                status = false;
        }
        if(status == true){
            status =  contactIDAO.update(c);
        }
        return status;
    }

}
