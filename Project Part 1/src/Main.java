import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Service service = new Service();
        Scanner console = new Scanner(System.in);
        //Carte carte = new Carte();
        //System.out.println(carte.pret);
        // System.out.println("Hello world!");

        while(true)
        {
            System.out.println("-----Logare cont----- ");
            System.out.println("Selectati tipul de user: ");
            System.out.println("1 - Admin ");
            System.out.println("2 - Client ");
            System.out.println("3 - Exit ");

            System.out.print("Introduceti numar optiune: ");
            int input = console.nextInt();

            if(input == 3)
            {
                break;
            }

            if(input == 2)
            {
                System.out.println("Sunteti logat ca user \n");
                // meniu user
                service.clientMenu();
            }

            if(input == 1)
            {
                System.out.println("Sunteti logat ca admin \n");
                // meniu admin
                service.adminMenu();
            }

        }
    }
}