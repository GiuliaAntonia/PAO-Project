import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Service {

    Scanner console = new Scanner(System.in);
     Map<Integer, Client> mapClienti = new HashMap<>();
     List<Carte> listaCarti = new ArrayList<>();
     List<Parfum> listaParfumuri = new ArrayList<Parfum>();
     List<Categorie> listaCateg = new ArrayList<Categorie>();
     List<Produs> listProduse = new ArrayList<>();
     List<Comanda> listaComenzi = new ArrayList<>();
     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
     Map<String, ArrayList<Produs>> cosCump = new HashMap<>();
     String user;


    public Service(){
        Client c1 = new Client("Popescu", "Ion", "Calea lui Train nr 104", "popion@gmail.com", "0747893450", new Date(1995,03,27), 10);
        mapClienti.put(10, c1);
        cosCump.put(c1.getEmail(), new ArrayList<Produs>());   // initialize cosul de cumparaturi

        Categorie categ1 = new Categorie(1, "Fictiune");
        Categorie categ2 = new Categorie(2,"Dezvoltare personala");
        Categorie categ3 = new Categorie(3, "floral");
        listaCateg.add(categ1);
        listaCateg.add(categ2);
        listaCateg.add(categ3);

        Carte car1 = new Carte(10,10,25,0,categ1, "Pe aripile vantului", "Margret Mitchell", "Rao",700);
        listaCarti.add(car1);
        listProduse.add(car1);

        Parfum p1 = new Parfum(20, 5, 300, 10, categ3, "Dolce Gabana", "The only one", 50);
        listaParfumuri.add(p1);
        listProduse.add(p1);
    }

    public void loginMenu()
    {
        while (true)
        {
            System.out.println("------Login-------- ");
            System.out.println("1 - Cont existent");
            System.out.println("2 - Creare cont");
            System.out.println("3 - Exit");

            System.out.print("Introduceti numar optiune: ");
            int input = console.nextInt();

            if(input == 3)
            {
                break;
            }

            if(input == 2)
            {
                introduClient();
            }

            if(input == 1)
            {
                System.out.print("Pentru identificare va rog sa introduceti adresa de email: ");
                String line = console.nextLine();
                String email = console.nextLine();

                int ok = 1;

                for(Map.Entry<Integer,Client> me : mapClienti.entrySet())
                {
                    Client c = me.getValue();
                    if(c.getEmail().equals(email))
                    {
                        ok = 0;
                        user = email;
                        System.out.println("\nBine ati revenit, " + c.getNume() + " " + c.getPrenume() + "!");

                        break;
                    }
                }

                if(ok == 1)
                {
                    System.out.println("\nAdresa de email introdusa nu este asociata nici unui cont");
                    System.out.println("Daca nu aveti cont, va rog sa va creati");
                    break;
                }
                break;
            }
        }
    }

    public void clientMenu()
    {
        loginMenu();

        while (true)
        {
            System.out.println("Optiuni: ");
            System.out.println("Optiunea 1: Vizualizare produse");
            System.out.println("Optiunea 2: Produse sortate dupa pret");
            System.out.println("Optiunea 3: Carti sortate dupa categorie");
            System.out.println("Optiunea 4: Parfumuri sortate dupa discount");
            System.out.println("Optiunea 5: Comanda produse");
            System.out.println("Optiunea 6: Exit");

            System.out.print("Introduceti numar optiune: ");
            int input = console.nextInt();

            if(input == 6)
            {
                break;
            }

            if(input == 1)
            {
                vizulizareProduse();
            }

            if(input == 2)
            {
                System.out.println("-----Produse sortate dupa pret-----");

                // La apel, metoda statică sort clasei utilitare Arrays va primica parametru un obiect al clasei SortByPrice
                // sub forma unei referințede tipul interfeței Comparator

                Collections.sort(listProduse, new SortByPrice());

                vizulizareProduse();

                System.out.print("Doriti sa adagati un produs in cos? [y/n]: ");
                String line = console.nextLine();
                String answear = console.nextLine();

                if(answear.equals("y"))
                {
                    adaugaInCos(user);
                }

            }

            if(input == 3)
            {
                System.out.println("-----Carti sortate dupa categori-----");

                Collections.sort(listaCarti, new Comparator<Carte>() {     // sort with comparator
                    @Override
                    public int compare(Carte c1, Carte c2) {
                        return c1.getCateg().getDenumire().compareTo(c2.getCateg().getDenumire());
                    }
                });

                for(int i = 0; i < listaCarti.size(); i++)    // afisare
                {
                    Carte c = listaCarti.get(i);
                    afisareCarte(c);
                    System.out.println("-----------------------------------");
                }

                System.out.print("Doriti sa adagati un produs in cos? [y/n]: ");
                String line = console.nextLine();
                String answear = console.nextLine();

                if(answear.equals("y"))
                {
                    adaugaInCos(user);
                }
            }

            if(input == 4)
            {
                System.out.println("-----Parfumuri sortate dupa discount descrescator-----");

                Collections.sort(listaParfumuri, new Comparator<Parfum>() {
                    @Override
                    public int compare(Parfum p1, Parfum p2) {
                        return p2.getDiscount() - p1.getDiscount();
                    }
                });

                for(int i = 0; i < listaParfumuri.size(); i++)    // afisare
                {
                    Parfum p = listaParfumuri.get(i);
                    afisareParfum(p);
                    System.out.println("-----------------------------------");
                }

                System.out.print("Doriti sa adagati un produs in cos? [y/n]: ");
                String line = console.nextLine();
                String answear = console.nextLine();

                if(answear.equals("y"))
                {
                    adaugaInCos(user);
                }
            }

            if (input == 5)
            {
                vizualizareCos(user);
                System.out.print("Doriti procesati comanda? [y/n]: ");
                String line = console.nextLine();
                String answear = console.nextLine();

                if(answear.equals("y"))
                {
                    Comanda com = new Comanda();
                    com.setCosCump(cosCump);
                    com.setData(new Date());
                    com.setIdComanda(listaComenzi.size()+1);
                    listaComenzi.add(com);

                    System.out.println("\n ------------------------------");
                    float total = calculeazaTotal(user);
                    if(total >= 200)
                    {
                        System.out.println("Transportul este gratuit");
                        System.out.println("Totalul comenzii este: " + total);
                    }
                    else
                    {
                        System.out.println("Transportul costa 20 RON");
                        System.out.println("Totalul comenzii este: " + (total + 20) + "RON");
                    }

                    float sumEc = calcSumaEconomisita(user);
                    System.out.println("Ati economisit: " + sumEc + " RON");
                    System.out.println("------------------------------\n ");

                    // afisare comanda
                    System.out.println("------Detalii comanda-------");
                    afisareComanda(com, user);

                    // golire cos
                    // dupa ce se proceseaza comanda, sterg produsele din lista
                    cosCump.get(user).clear();
                }
            }
        }
    }

    public void adminMenu()
    {
        while (true)
        {
            System.out.println("Optiuni: ");
            System.out.println("Optiunea 1: Vizualizare clienti");
            System.out.println("Optiunea 2: Adauga produs");
            //System.out.println("Optiunea 3: Modifica produs - unavailable");
            System.out.println("Optiunea 3: Sterge produs");
            System.out.println("Optiunea 4: Adauga categorie");
            System.out.println("Optiunea 5: Modifica categorie");
            System.out.println("Optiunea 6: Sterge categorie");
            System.out.println("Optiunea 7: Exit");

            System.out.print("Introduceti numar optiune: ");
            int input = console.nextInt();

            if(input == 7)
            {
                break;
            }

            if(input == 1)
            {
                System.out.println("----Afisare clienti-----");
                for(Map.Entry<Integer,Client> me : mapClienti.entrySet())
                {
                    System.out.println("Key: " + me.getKey() + "\n" + me.getValue().toString() + "\n");
                }
            }

            if(input == 2)
            {
                System.out.println("----Selectati tipul de produs----");
                System.out.println("1 - Carte");
                System.out.println("2 - Parfum");

                System.out.print("Introduceti numar optiune: ");
                int input2 = console.nextInt();

                if(input2 == 1)
                {
                    introduCarte();
                }

                if(input2 == 2)
                {
                    introduParfum();
                }
            }

//            if (input == 3)            // modificare prod => REVENIRE
//            {
//                vizulizareProduse();
//
//                System.out.print("Selectati id-ul produsului pe care doriti sa il modificati: ");
//                int idProd = console.nextInt();
//
//                System.out.println("\n This function is unavailable at the moment \n");
//
//                Produs modifProd = getProdById(idProd);
//
//            }

            if(input == 3)
            {
                vizulizareProduse();

                System.out.print("Selectati id-ul produsului pe care doriti sa il stergeti: ");
                int idProd = console.nextInt();

                for(int i = 0; i < listProduse.size(); i++)
                {
                    Produs prod = listProduse.get(i);
                    if(prod.getIdProdus() == idProd)           // selectez produsul cu id-ul dat din lista
                    {
                        boolean removedProd = listProduse.remove(prod);   // il elimin din lista produse

                        // verif sa vada daca p este carte sau parfum
                        // pt a il elimina din lista corespunzatoare
                        if(listaCarti.contains(prod))
                        {
                            boolean removedProdC = listaCarti.remove(prod);
                        }
                        else
                        {
                            boolean removedProdP = listaParfumuri.remove(prod);
                        }

                        break;
                    }
                }

                System.out.println("-----Dupa stergere------");
                vizulizareProduse();

            }

            if(input == 4)
            {
                introduCateg();
            }

            if(input == 5)           // modificare categ => REVENIRE
            {
                vizualizareCateg();

                System.out.print("Selectati id-ul produsului pe care doriti sa il modificati: ");
                int idCateg = console.nextInt();

                System.out.println("Introduceti noua denumire: ");
                String line = console.nextLine();
                String newDenumire = console.nextLine();

                try{
                    Categorie modifCateg = getCategById(idCateg);
                    modifCateg.setDenumire(newDenumire);
                }
                catch (Exception e)
                {
                    System.out.println("Nu exista categorie cu id-ul introdus");
                }

            }

            if(input == 6)
            {
                vizualizareCateg();

                System.out.print("Selectati id-ul categoriei pe care doriti sa o stergeti: ");
                int idCateg = console.nextInt();

                for(int i = 0; i < listaCateg.size(); i++)
                {
                    Categorie categ = listaCateg.get(i);
                    if(categ.getIdCateg() == idCateg)
                    {
                        boolean removeCateg = listaCateg.remove(categ);
                    }
                }

                System.out.println("-----Dupa stergere------");
                vizualizareCateg();
            }
        }
    }

    public void vizualizareCos(String user)
    {
        System.out.println("----Cosul dvs.----");

        ArrayList<Produs> ls = cosCump.get(user);


        for(int i = 0; i < ls.size(); i++)
        {
            Produs p = ls.get(i);

            // verif sa vada daca p este carte sau parfum
            // pt a afisa corespunzator
            if(listaCarti.contains(p))
            {
                Carte c = (Carte) p;        // downcasting
                afisareCarte(c);
                System.out.println("-----------------------------------");
            }
            else
            {
                Parfum pf = (Parfum) p;    // downcasting
                afisareParfum(pf);
                System.out.println("----------------------------------");
            }

        }
    }

    public  void vizualizareCateg()
    {
        for (int i = 0; i < listaCateg.size(); i++)
        {
            Categorie categ = listaCateg.get(i);
            afisareCateg(categ);
            System.out.println("-----------------------------------");

        }
    }
    public void vizulizareProduse()
    {
        System.out.println("----Produs disponibile in magazin----");

        for(int i = 0; i < listProduse.size(); i++)
        {
            Produs p = listProduse.get(i);

            // verif sa vada daca p este carte sau parfum
            // pt a afisa corespunzator
            if(listaCarti.contains(p))
            {
                Carte c = (Carte) p;        // downcasting
                afisareCarte(c);
                System.out.println("-----------------------------------");
            }
            else
            {
                Parfum pf = (Parfum) p;    // downcasting
                afisareParfum(pf);
                System.out.println("----------------------------------");
            }

        }
    }
    public void introduProdus(Produs p)
    {
//        System.out.print("Id produs: ");
//        int id = console.nextInt();
//        p.setIdProdus(id);

        // id-ul produsului nou adaugate este = ultimul id din lista + 1
        Produs lastProd = listProduse.get(listProduse.size()-1);
        p.setIdProdus(lastProd.getIdProdus() + 1);

        System.out.print("Cantitate: ");
        int cantitate = console.nextInt();
        p.setCantitate(cantitate);

        System.out.print("Pret: ");
        int pret = console.nextInt();
        p.setPret(pret);

        System.out.print("Discount: ");
        int discount = console.nextInt();
        p.setDiscount(discount);

        System.out.println("Categorii: ");
        for (int i = 0; i< listaCateg.size(); i++)
        {
            Categorie categ = (Categorie) listaCateg.get(i);
            System.out.println( i + " - " + categ.toString());
        }

        System.out.print("Selecteaza o categorie existenta: ");

        int categOption = console.nextInt();
        Categorie categValue = (Categorie) listaCateg.get(categOption);
        p.setCateg(categValue);

    }

    public void afisareCarte(Carte c)
    {
        System.out.print(c.toString());
    }

    public void afisareParfum(Parfum p)
    {
        System.out.print(p.toString());
    }

    public void afisareCateg(Categorie c)
    {
        System.out.println(c.getIdCateg());
        System.out.println(c.toString());
    }

    public void afisareClient(Client c)
    {
        System.out.println(c.toString());
    }

    public void afisareComanda(Comanda c, String user)
    {
        System.out.println("Id comanda: " + c.getIdComanda());
        System.out.println("Data plasare: " + format.format(c.getData()));
        System.out.println("Produse\n" + c.getCosCump().get(user));

        // estimare data sosire
        System.out.print("Comanda dvs. va ajunge pe in aproximativ 5 zile: " );

        // Calendar e o clasa abstracta
        // getInstance -> metoda statica pt instantiere
        // getTime -> returneaza un obiect de tip date

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5);
        System.out.println(format.format(cal.getTime()));
    }

    public void introduCarte()
    {
        System.out.println("---- Introduceti detalii carte----");

        Carte carte = new Carte();
        introduProdus(carte);

        System.out.print("Titlu: ");
        String line = console.nextLine();
        String titlu = console.nextLine();
        carte.setTitlu(titlu);

        System.out.print("Autor: ");
        String autor = console.nextLine();
        carte.setAutor(autor);

        System.out.print("Editura: ");
        String editura = console.nextLine();
        carte.setEditura(editura);

        System.out.print("Numar pagini: ");
        int nrPg = console.nextInt();
        carte.setNrPg(nrPg);

        listaCarti.add(carte);
        listProduse.add(carte);

        System.out.println("\n---- Ati introdus cartea----");
        afisareCarte(carte);
        System.out.println("\n");

    }

    public void introduParfum()
    {
        System.out.println("---- Introduceti detalii parfum----");

        Parfum parfum = new Parfum();
        introduProdus(parfum);

        System.out.print("Brand: ");
        String line = console.nextLine();
        String brand = console.nextLine();
        parfum.setBrand(brand);

        System.out.print("Denumire: ");
        String denumire = console.nextLine();
        parfum.setDenumire(denumire);

        System.out.print("Numar ml: ");
        int nrMl = console.nextInt();
        parfum.setNrMl(nrMl);

        listaParfumuri.add(parfum);
        listProduse.add(parfum);

        System.out.println("\n---- Ati introdus parfumul----");
        afisareParfum(parfum);
        System.out.println("\n");
    }

    public void introduCateg()
    {
        System.out.println("---- Introduceti detalii categorie----");

        Categorie categorie = new Categorie();

        // id-ul categoriei nou adaugate este = ultimul id din lista + 1
        Categorie lastCateg = listaCateg.get(listaCateg.size()-1);
        categorie.setIdCateg(lastCateg.getIdCateg() + 1);

        System.out.print("Denumire: ");
        String line = console.nextLine();
        String denumire = console.nextLine();
        categorie.setDenumire(denumire);

        listaCateg.add(categorie);

        System.out.println("\n---- Ati introdus categoria----");
        afisareCateg(categorie);
    }

    public void introduClient()
    {
        System.out.println("----Introduceti detalii personale---");

        Client client = new Client();

        System.out.print("Nume: ");
        String lala = console.nextLine();
        String nume = console.nextLine();
        client.setNume(nume);

        System.out.print("Prenume: ");
        String prenume = console.nextLine();
        client.setPrenume(prenume);

        System.out.print("Adresa: ");
        String adresa = console.nextLine();
        client.setAdresa(adresa);

        System.out.print("Email: ");
        String email = console.nextLine();
        client.setEmail(email);

        System.out.print("Telefon: ");
        String tel = console.nextLine();
        client.setTelefon(tel);

        System.out.print("Data nasterii: ");
        String data = console.nextLine();


        try {
            Date dateT = format.parse(data);    // transformam string-ul citit in data folosind formatul SimpleDateFormat format
            client.setData_n(dateT);           // stringul citit trebuie sa aibe forma data, altfel nu poate fi transformat => EROARE
        }catch (ParseException e)
        {
            e.printStackTrace();             // trace the exception
        }

        Integer key = 0;
        for (Map.Entry<Integer,Client> me : mapClienti.entrySet())
        {
            key = me.getKey();
        }

        client.setIdClient(key+1);
        mapClienti.put(key+1, client);

        System.out.println("\n--------S-au inregistrat urmatoarele date---------");
        afisareClient(client);

        // initialize cosul de cumparaturi
        cosCump.put(email, new ArrayList<Produs>());
    }

    public Categorie getCategById(int catgId)
    {
        for(Categorie c: listaCateg)
        {
            if(c.getIdCateg() == catgId)
            {
                return c;
            }
        }
        return null;
    }

    public Produs getProdById(int prodId)
    {
        for(Produs p: listProduse)
        {
            if(p.getIdProdus() == prodId)
                return p;
        }
        return null;
    }

    public void adaugaInCos(String user)
    {
        System.out.print("Introduceti id-ul produsului pe care doriti sa il comandati: ");
        int idP = console.nextInt();

        int ok = 0;
        for(int i = 0; i< listProduse.size(); i++)
        {
            Produs prod = listProduse.get(i);
            if(prod.getIdProdus() == idP)        // gasesc produsul de adaugat in cos
            {
                if(prod.getCantitate() > 0)    // verific daca prod este disponibil
                {
                    ok = 1;
//                    prodCump.add(prod);
                    cosCump.get(user).add(prod);
                    prod.setCantitate(prod.getCantitate() - 1);
                    System.out.println("Produsul a fost adaugat cu succes!");
                    break;
                }
            }
        }

        if(ok == 0){
            System.out.println("Produsul nu s-a gasit sau nu este disponibil");
        }
    }

    public float calculeazaTotal(String user)
    {
        ArrayList<Produs> ls = cosCump.get(user);
        float sum = 0;
        for (Produs p: ls)
        {
            sum += p.getPret();
        }
        return sum;
    }

    public float calcSumaEconomisita(String user)
    {
        ArrayList<Produs> ls = cosCump.get(user);
        float sumEc = 0;
        float pret_vechi;
        for (Produs p: ls)
        {
            pret_vechi = (float)p.getPret() / (1 - (float)p.getDiscount()/100);
            sumEc += pret_vechi - p.getPret();
        }
        return sumEc;
    }

}
