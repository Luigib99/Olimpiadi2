package Controller;

import Service.*;
import Entity.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AtletaController {
    Scanner scanner = new Scanner(System.in);
    SportService sportService = new SportService();
    AtletaService atletaService = new AtletaService();

    public void createAtleta()
    {
       System.out.println("Inserisci un Nome del Atleta");
       String nome = scanner.nextLine();
       System.out.println("Inserisci il cognome dell'Atleta");
       String cognome = scanner.nextLine();
       System.out.println("Inserisci la data di nascita dell'atleta (yyyy-mm-dd)");
       LocalDate dataNascita = LocalDate.parse(scanner.nextLine());
       System.out.println("Inserisci l'altezza del Atleta");
       int altezza = scanner.nextInt();
       System.out.println("Inserisci l'id dello sport dalla lista");
        List<Sport> listaSport = sportService.readSport();
       if (listaSport.size() == 0)
       {
           System.out.println("non sono ancora presenti sport");
       }
       else
       {
           sportService.readSport();
           int idSport = scanner.nextInt();
           for (int i = 0; i < listaSport.size(); i++)
           {
               if (listaSport.get(i).getId() == idSport)
               {
                   Sport sport = listaSport.get(i);
                   AtletaService atletaService = new AtletaService();
                   atletaService.createAtleta(idSport,nome,cognome,dataNascita,altezza,sport);
               }
           }
       }
        System.out.println("premere un tasto per continuare");
        String tasto = scanner.nextLine();
    }

    public void readAtleta()
    {
        List<Atleta> listaAtleta = atletaService.readAtleta();
        if (listaAtleta.size() == 0)
        {
            System.out.println("non sono ancora presenti atleti");
        }
        else
        {
            for (Atleta atleta : listaAtleta)
            {
                Sport sport = atleta.getSport();
                if (sport != null)
                {
                    System.out.println(atleta.getId() + " " +
                            atleta.getNome() + " " +
                            atleta.getCognome() + " " +
                            sport.getNomeSport());
                }
                else
                {
                    System.out.println(atleta.getId() + " " +
                            atleta.getNome() + " " +
                            atleta.getCognome() + " " +
                            "sport non assegnato");
                }
            }
        }
        System.out.println("premere un tasto per continuare");
        String tasto = scanner.nextLine();
    }

    public void deleteAtleta () {

        List<Atleta> listaAtleta = atletaService.readAtleta();

        if (listaAtleta.size() == 0) {
            System.out.println("non sono ancora presenti atleti");
        } else {
            System.out.println("Elimina l'atleta digitando l'id: ");
            readAtleta();
            int id = scanner.nextInt();
            SportService sportService = new SportService();
            sportService.deleteSport(id);
        }
        System.out.println("premere un tasto per continuare");
        String tasto = scanner.nextLine();
    }

    public void updateAtleta()
    {
        List<Atleta> listaAtleta = atletaService.readAtleta();

        if (listaAtleta.size() == 0)
        {
            System.out.println("non sono ancora presenti atleti");
        }
        else
        {
            System.out.println("Modifica l'atleta digitando l'id: ");
            readAtleta();
            int id = scanner.nextInt();
            for (Atleta atleta : listaAtleta)
            {
                if (atleta.getId() == id)
                {
                    System.out.println("Modifica il nome del atleta");
                    String nome = scanner.nextLine();

                    atletaService.updateAtleta(id,nome);
                }
            }
        }
        System.out.println("premere un tasto per continuare");
        String tasto = scanner.nextLine();
    }
}
