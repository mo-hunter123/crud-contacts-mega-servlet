package ma.fstm.ilisi.ges_contact.contactmegaservlet2.model.bo;

public class Type {
    private String titre;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        if (titre != null ? !titre.equals(type.titre) : type.titre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return titre != null ? titre.hashCode() : 0;
    }
}
