package Controller;

import Service.*;
import Entity.*;
import java.util.*;

public class QueryController {
    String tasto;
    Scanner scanner = new Scanner(System.in);
    SportController sportController = new SportController();
    SportService sportService = new SportService();
    AtletaService atletaService = new AtletaService();
    QueryService queryService = new QueryService();

    //l'elenco degli sport di squadra
    public void query1()
    {
        List<Sport> listaSportSquadra = queryService.query1();

        System.out.println("\nSPORT DI SQUADRA:");
        for (Sport sport : listaSportSquadra)
        {
            System.out.println(sport.getNomeSport()+" ");
        }
        System.out.println("\ndigita un tasto per continuare");
        tasto = scanner.nextLine();
    }

    public void query2()
    {
        List<Atleta> listaTennistiMillenial = queryService.query2();

        System.out.println("\nTENNISTI MILLENNIAL:");
        for (Atleta atleta : listaTennistiMillenial)
        {
            System.out.println(atleta.getNome()+" "+atleta.getCognome()+ " "+atleta.getDataNascita());
        }
        System.out.println("\ndigita un tasto per continuare");
        tasto = scanner.nextLine();
    }

    public void query3()
    {
        System.out.println("seleziona lo sport dall'id");
        sportController.readSport(false);
        int choice3 = scanner.nextInt();
        List <Atleta> listaAtletiSport = queryService.query3(choice3);

        System.out.println("\n");
        for (Atleta atleta: listaAtletiSport)
        {
            System.out.println(atleta.getNome() + " "+ atleta.getCognome());
        }
        scanner.nextLine();
        System.out.println("\ndigita un tasto per continuare");
        tasto = scanner.nextLine();
    }

    public void query4()
    {
        System.out.println("seleziona lo sport dall'id");
        sportController.readSport(false);
        int choice3 = scanner.nextInt();
        List <Sport> listaNumeroAtletiSport = queryService.query4(choice3);
        for (Sport sport: listaNumeroAtletiSport)
        {
            System.out.println("il numero di atleti salvati sono " + listaNumeroAtletiSport);
        }
        scanner.nextLine();
        System.out.println("\ndigita un tasto per continuare");
        tasto = scanner.nextLine();
    }

    public void query5()
    {
        List <Sport> listaSportConGiocatori = queryService.query5();

        System.out.println("\ngli sport con più di 2 giocatori salvati sono");
        for (Sport sport: listaSportConGiocatori)
        {
            System.out.println(sport.getNomeSport());
        }
        System.out.println("\ndigita un tasto per continuare");
        tasto = scanner.nextLine();
    }

    public void query6()
    {
        List <Atleta> listaAtletiAlti = queryService.query6();
        System.out.println("\ngli atleti piu alti della media sono: ");
        for (Atleta atleta: listaAtletiAlti)
        {
            System.out.println(atleta.getNome() + " " + atleta.getCognome());
        }
        System.out.println("\ndigita un tasto per continuare");
        tasto = scanner.nextLine();

    }
}
