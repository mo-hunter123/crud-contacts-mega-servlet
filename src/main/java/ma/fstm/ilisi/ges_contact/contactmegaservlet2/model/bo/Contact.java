package ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.bo;

public class Contact {
    private int id;
    private String nom;
    private String telephone;
    private String tType;
    private String adresse;

    public Contact(){

    }

    public Contact(String nom, String telephone, String type, String adresse){
        this.nom = nom;
        this.telephone = telephone;
        this.tType = type;
        this.adresse = adresse;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String gettType() {
        return tType;
    }

    public void settType(String tType) {
        this.tType = tType;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (nom != null ? !nom.equals(contact.nom) : contact.nom != null) return false;
        if (telephone != null ? !telephone.equals(contact.telephone) : contact.telephone != null) return false;
        if (tType != null ? !tType.equals(contact.tType) : contact.tType != null) return false;
        if (adresse != null ? !adresse.equals(contact.adresse) : contact.adresse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (tType != null ? tType.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", tType='" + tType + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
