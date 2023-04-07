import java.util.Date;
public class Persoana {
    protected String nume;
    protected String prenume;
    protected String adresa;
    protected String email;
    protected String telefon;
    protected Date data_n;

    // constructor cu toti parametri
    public Persoana(String nume, String prenume, String adresa, String email, String telefon, Date data_n){
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.email = email;
        this.telefon = telefon;
        this.data_n = data_n;
    }

    // constructor fara parametri
    public Persoana(){
        this.nume = "necunoscut";
        this.prenume = "necunoscut";
        this.adresa = "necunoscut";
        this.email = "necunoscut";
        this.telefon = "necunoscut";
        this.data_n = null;
    }
    
    // setters
    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setData_n(Date data_n) {
        this.data_n = data_n;
    }

    // getters
    public String getEmail() {
        return email;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }
}
