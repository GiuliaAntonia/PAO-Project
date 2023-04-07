public class Parfum extends Produs{
    private String brand;
    private String denumire;
    private int nrMl;

    // constructor cu parametrii
    public Parfum(int idProdus, int cantitate, int pret, int discount, Categorie categ, String brand, String denumire, int nrMl)
    {
        super(idProdus, cantitate, pret, discount, categ);
        this.brand = brand;
        this.denumire = denumire;
        this.nrMl = nrMl;
    }

    // constructor fara parametrii
    public Parfum()
    {
        super();
        this.brand = "none";
        this.denumire = "none";
        this.nrMl = 0;
    }

    // kind of copy constructor
    public Parfum(Parfum parfum)
    {
        super(parfum);
        this.brand = parfum.brand;
        this.denumire = parfum.brand;
        this.nrMl = parfum.nrMl;
    }

    // setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setNrMl(int nrMl) {
        this.nrMl = nrMl;
    }

    @Override
    public String toString() {
        String rezult = "Id parfum: " + idProdus + "\n" +
                "Brand: " + brand + "\n" +
                "Denumire: " + denumire + "\n" +
                "Numar ml: " + nrMl + "\n" +
                "Pret: " + pret + "\n" +
                "Discount: " + discount + "\n" +
                "Categorie: " + categ.toString() + "\n" +
                "Cantitate: " + cantitate + "\n";
        return rezult;
    }
}
