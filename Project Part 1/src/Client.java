import java.util.Date;

public class Client extends Persoana{
    public int idClient;

    // constructor cu toti parametrii
    public Client(String nume, String prenume, String adresa, String email, String telefon, Date data_n, int idClient)
    {
        super(nume, prenume, adresa, email, telefon, data_n);
        this.idClient = idClient;
    }

    public Client()
    {
        this.idClient = 0;
    }

    // setters
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        String rezult = "Nume: " + nume + "\n" +
                        "Prenume: " + prenume + "\n" +
                        "Adresa: " + adresa + "\n" +
                        "Email: " + email + "\n" +
                        "Telefon: " + telefon + "\n" +
                        "Data nasterii: " + data_n + "\n";
        return rezult;
    }
}
