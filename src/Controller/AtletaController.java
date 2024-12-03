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
    SportController sportController = new SportController();

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
           System.out.println("premere un tasto per continuare");
           String tasto = scanner.nextLine();
       }
       else
       {
           sportController.readSport(true);
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
            System.out.println("premere un tasto per continuare");
            String tasto = scanner.nextLine();
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
                    String nome=atleta.getNome();
                    String cognome=atleta.getCognome();
                    LocalDate dataNascita=atleta.getDataNascita();
                    int altezza=atleta.getAltezza();
                    Sport sport=atleta.getSport();

                    System.out.println("Scegli quale parametro modificare digitando il numero");
                    System.out.println("1) NOME, attuale: " + atleta.getNome());
                    System.out.println("2) COGNOME, attuale: " + atleta.getCognome());
                    System.out.println("3) DATA DI NASCITA, attuale: " + atleta.getDataNascita());
                    System.out.println("4) ALTEZZA, attuale: " + atleta.getAltezza());
                    System.out.println("5) SPORT : " + atleta.getSport().getNomeSport());
                    System.out.println("ALTRO) TUTTI I PARAMETRI");
                    int choiceUpdate = scanner.nextInt();
                    scanner.nextLine();

                    if (choiceUpdate == 1)
                    {
                        System.out.println("Scrivi il nuovo nome");
                        nome=scanner.nextLine();
                    }
                    else if (choiceUpdate == 2)
                    {
                        System.out.println("Scrivi il nuovo cognome");
                        cognome=scanner.nextLine();
                    }
                    else if (choiceUpdate == 3)
                    {
                        System.out.println("Scrivi la nuova data nascita (yyyy-mm-dd)");
                        dataNascita = LocalDate.parse(scanner.nextLine());
                    }
                    else if (choiceUpdate == 4)
                    {
                        System.out.println("Scrivi la nuova altezza");
                        altezza=scanner.nextInt();
                    }
                    else if (choiceUpdate == 5)
                    {
                        System.out.println("Digita il numero corrispondente al nuovo sport");
                        sportController.readSport(true);
                        int idSport = scanner.nextInt();
                        List<Sport> listaSport = sportService.readSport();
                        for (int i = 0; i < listaSport.size(); i++)
                        {
                            if (listaSport.get(i).getId() == idSport)
                            {
                                sport = listaSport.get(i);
                            }
                        }
                    }
                    atletaService.updateAtleta(id,nome,cognome,dataNascita,altezza,sport, choiceUpdate);
                }
            }
        }
    }
}
