// import Persoana.java;
import java.util.Date;

public class Admin extends Persoana {
    public int idAdmin;

    // constructor cu toti parametrii
    public Admin(String nume, String prenume, String adresa, String email, String telefon, Date data_n, int idAdmin)
    {
        super(nume, prenume, adresa, email, telefon, data_n);
        this.idAdmin = idAdmin;
    }
}
