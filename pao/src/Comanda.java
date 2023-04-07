import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Comanda {

    private int idComanda;
    private Date data;
    Map<String, ArrayList<Produs>> cosCump = new HashMap<>();

    public Comanda(int idComanda, Date data, Cos_Cumparaturi dateCos)
    {
        this.idComanda = idComanda;
        this.data = data;
        this.cosCump = cosCump;
    }

    public Comanda()
    {
        this.idComanda = 0;
        this.data = null;
        this.cosCump = null;
    }

    // setters
    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public void setData(Date data) {
        this.data = data;
    }

    // getters
    public int getIdComanda() {
        return idComanda;
    }

    public Date getData() {
        return data;
    }

    public Map<String, ArrayList<Produs>> getCosCump() {
        return cosCump;
    }

    public void setCosCump(Map<String, ArrayList<Produs>> cosCump) {
        this.cosCump = cosCump;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "idComanda=" + idComanda +
                ", data=" + data +
                ", dateCos=" + cosCump +
                '}';
    }
}
