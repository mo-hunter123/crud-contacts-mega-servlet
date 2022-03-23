package ma.fstm.ilisi.ges_contact.contactmegaservlet2.controller;


import ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.bo.Contact;
import ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.dao.DAOContact;
import ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.sevice.ContactValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MegaServlet extends HttpServlet {

    public enum ReqType_POST{
        INSERTION,
        DELETION,
        MODIFICATION
    }

    public enum ReqType_GET{
        CONSULTATION
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String nom = req.getParameter("nom");
        String adresse = req.getParameter("adresse");
        String type = req.getParameter("type");
        String numero = req.getParameter("numero");

        Contact contactToWorkOn = new Contact(nom, numero, type, adresse);

        String reqType = req.getRequestURI();
        System.out.println("Post: "+reqType);

        if(reqType.equals("/ContactMegaServlet2_war/insert.do")) {
            boolean inserted = new ContactValidator().validateContact(contactToWorkOn);
            if (!inserted)
                throw new ServletException("Problem de donnees");
        }

        else if(reqType.equals("/ContactMegaServlet2_war/delete.do")){
            System.out.println("We are here");
            int id = Integer.parseInt(req.getParameter("id"));
            contactToWorkOn.setId(id);
            boolean deleted = new ContactValidator().deleteContact(contactToWorkOn);
            if(!deleted)
                throw new ServletException("Problem de donnees on DELETION");
        }

        else if(reqType.equals("/ContactMegaServlet2_war/modify.do")){
            int id = Integer.parseInt(req.getParameter("id"));
            System.out.println("Id to modify: "+id);
            contactToWorkOn.setId(id);
            boolean updated = new ContactValidator().updateContact(contactToWorkOn);
            if(!updated)
                throw new ServletException("Problem de donnees on Modification");
        }

        // Redirection in all cases when finished ==> OK
        resp.sendRedirect(getServletContext().getContextPath()+"/admin.do");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String reqType = req.getRequestURI();
        System.out.println(reqType);

        if(reqType.equals("/ContactMegaServlet2_war/admin.do")){

            List<Contact> contacts = new DAOContact().getAll();
            req.setAttribute("contacts", contacts);

            RequestDispatcher rd = req.getRequestDispatcher("/Template/Admin.jsp");
            rd.forward(req, resp);
        }

        else if(reqType.equals("/ContactMegaServlet2_war/update.do")){
            int id = Integer.parseInt(req.getParameter("id"));
            Contact c = new DAOContact().findByID(id);

            req.setAttribute("contact", c);

            RequestDispatcher rd = req.getRequestDispatcher("/Template/ModifierContact.jsp");
            rd.forward(req, resp);
        }
        else if(reqType.equals("/ContactMegaServlet2_war/insert.do")){

            RequestDispatcher rd = req.getRequestDispatcher("/Template/AjouterContact.jsp");
            rd.forward(req, resp);
        }
        else {
            RequestDispatcher rd = req.getRequestDispatcher("/errorPage.jsp");
            rd.forward(req, resp);
        }
    }
}
