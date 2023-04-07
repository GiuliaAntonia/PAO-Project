import jdk.jfr.Category;

import java.util.Comparator;

public class Produs {
    protected int idProdus;
    protected  int cantitate;
    protected int pret;
    protected int discount;
    protected Categorie categ;    // agregare -> categoria poate exista fara produs

    // constructor cu toti parametrii
    public Produs (int idProdus, int cantitate, int pret, int discount, Categorie categ)
    {
        this.idProdus = idProdus;
        this.cantitate = cantitate;
        this.pret = pret;
        this.discount = discount;
        this.categ = categ;
    }

    // constr fara parametrii
    public Produs(){
        this.idProdus = 0;
        this.cantitate = 0;
        this.pret = 0;
        this.discount = 0;
        this.categ = null;
    }

    // kind of copy constructor
    public Produs(Produs produs)
    {
        this.idProdus = produs.idProdus;
        this.cantitate = produs.cantitate;
        this.pret = produs.pret;
        this.discount = produs.discount;
        this.categ = produs.categ;
    }

    // setters

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setCateg(Categorie categ) {
        this.categ = categ;
    }

    // getters
    public int getIdProdus() {
        return idProdus;
    }

    public int getPret() {
        return pret;
    }

    public Categorie getCateg() {
        return categ;
    }

    public int getDiscount() {
        return discount;
    }

    public int getCantitate() {
        return cantitate;
    }

    @Override
    public String toString() {
        String rezult = "Id: " + idProdus + "\n" +
                "Cantitate: " + pret + "\n" +
                "Pret: " + pret + "\n" +
                "Discount: " + discount + "\n" +
                "Categorie: " + categ + "\n";
        return rezult;
    }
}
