public class Carte extends Produs {
    private String titlu;
    private String autor;
    private String editura;
    private Integer nrPg;

    // constructor cu parametrii
    public Carte(int idProdus, int cantitate, int pret, int discount, Categorie categ,
                 String titlu, String autor, String editura, Integer nrPg)
    {
        super(idProdus, cantitate, pret, discount, categ);
        this.titlu = titlu;
        this.autor = autor;
        this.editura = editura;
        this.nrPg = nrPg;
    }

    // constr fara parametrii
    public Carte(){
        super();
        this.titlu = "none";
        this.autor = "none";
        this.editura = "none";
        this.nrPg = 0;
    }

    // kind of copy constr
    public Carte(Carte carte)
    {
        super(carte);
        this.titlu = carte.titlu;
        this.autor = carte.autor;
        this.editura = carte.editura;
        this.nrPg = carte.nrPg;
    }

    // setters
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public void setNrPg(Integer nrPg) {
        this.nrPg = nrPg;
    }

    //getters

    public String getTitlu() {
        return titlu;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditura() {
        return editura;
    }

    public Integer getNrPg() {
        return nrPg;
    }

    @Override
    public String toString() {
        String rezult = "Id carte: " + idProdus + "\n" +
                "Titlu: " + titlu + "\n" +
                "Autor: " + autor + "\n" +
                "Pret: " + pret + "\n" +
                "Discount: " + discount + "\n" +
                "Categorie: " + categ.toString() + "\n" +
                "Cantitate: " + cantitate + "\n" +
                "Editura: " + editura + "\n" +
                "Numar pagini: " + nrPg + "\n";
        return rezult;
    }

}
