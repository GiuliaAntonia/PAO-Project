import java.util.ArrayList;
import java.util.List;

public class Cos_Cumparaturi {
    private int idCos;
    private List<Produs> listaProd;

    // constructori
    public Cos_Cumparaturi(int idCos, List<Carte> listaCarti, List<Parfum> listaParfumuri)
    {
        this.idCos = idCos;
        this.listaProd = listaProd;
    }

    public Cos_Cumparaturi ()
    {
        this.idCos = 0;
        this.listaProd = null;
    }

    // setteri
    public void setIdCos(int idCos)
    {
        this.idCos = idCos;
    }

    public void setListaProd(List<Produs> listaProd) {
        this.listaProd = listaProd;
    }

    // getteri
    public int getIdCos()
    {
        return idCos;
    }

    public List<Produs> getListaProd() {
        return listaProd;
    }

    @Override
    public String toString()
    {
        String result = "Cos id " + idCos + '\n';
        if(listaProd!= null)
            for(Produs p: listaProd)
            {
                result += p.toString();
            }

        return  result;
    }
}
