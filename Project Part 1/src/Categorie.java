public class Categorie {
    private int idCateg;
    private String denumire;

    // constr cu toti param
    public Categorie(int idCateg, String denumire)
    {
        this.idCateg = idCateg;
        this.denumire = denumire;
    }

    // constr fara param
    public Categorie()
    {
        this.idCateg = 0;
        this.denumire = "none";
    }

    // kind of copy constr
    public Categorie(Categorie categ)
    {
        this.idCateg = categ.idCateg;
        this.denumire = categ.denumire;
    }

    // setters
    public void setIdCateg(int idCateg) {
        this.idCateg = idCateg;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    //getters
    public int getIdCateg() {
        return idCateg;
    }

    public String getDenumire() {
        return denumire;
    }

    @Override
    public String toString() {
        return denumire;
    }
}
