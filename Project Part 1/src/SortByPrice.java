import java.util.Comparator;

public class SortByPrice implements Comparator<Produs> {
    @Override
    public int compare(Produs p1, Produs p2)
    {
        return p1.getPret() - p2.getPret();
    }
}
