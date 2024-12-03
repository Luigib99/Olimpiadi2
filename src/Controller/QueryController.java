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

    public void query3(int choice3)
    {
        Sport sportScelto = new Sport();

        System.out.println("seleziona lo sport dall'id");
        sportController.readSport(false);
        choice3 = scanner.nextInt();
        List <Atleta> listaAtletiSport = queryService.query3(choice3);

        for (Atleta atleta: listaAtletiSport)
        {
            System.out.println(atleta.getNome() + " "+atleta.getCognome());
        }
        System.out.println("\ndigita un tasto per continuare");
        tasto = scanner.nextLine();
    }
}
