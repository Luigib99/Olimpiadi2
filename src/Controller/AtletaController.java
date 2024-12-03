package Controller;

import Service.*;
import Entity.*;

import java.time.LocalDate;
import java.util.*;

public class AtletaController {
    String tasto;
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
       }
       else
       {
           sportController.readSport(false);
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
       scanner.nextLine();
       System.out.println("\nATLETA CREATO");
       System.out.println("\npremere un tasto per continuare");
       tasto = scanner.nextLine();
    }

    public void readAtleta(boolean completo)
    {
        List<Atleta> listaAtleta = atletaService.readAtleta();
        if (listaAtleta.size() == 0)
        {
            System.out.println("non sono ancora presenti atleti");
            System.out.println("\npremere un tasto per continuare");
            tasto = scanner.nextLine();
        }
        else
        {
            if (completo) {
                System.out.println("\nLISTA ATLETI\n");
                for (Atleta atleta : listaAtleta) {
                    Sport sport = atleta.getSport();
                    System.out.println(atleta.getId() + " " +
                            atleta.getNome() + " " +
                            atleta.getCognome() + " " +
                            atleta.getDataNascita() + " " +
                            atleta.getAltezza() + " " +
                            sport.getNomeSport());
                }
                System.out.println("\npremere un tasto per continuare");
                tasto = scanner.nextLine();
            }
            else
            {
                for (Atleta atleta : listaAtleta)
                {
                    System.out.println("id:" + atleta.getId() + " " +
                            atleta.getNome() + " " +
                            atleta.getCognome());
                }
            }
        }
    }

    public void deleteAtleta ()
    {

        List<Atleta> listaAtleta = atletaService.readAtleta();

        if (listaAtleta.size() == 0)
        {
            System.out.println("\nnon sono ancora presenti atleti");
        }
        else
        {
            System.out.println("Elimina l'atleta digitando l'id: ");
            readAtleta(false);
            int id = scanner.nextInt();
            atletaService.deleteAtleta(id);
            System.out.println("\nATLETA ELIMINATO");
            scanner.nextLine();
        }
        System.out.println("\npremere un tasto per continuare");
        tasto=scanner.nextLine();

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
            System.out.println("\nModifica l'atleta digitando l'id:\n");
            readAtleta(false);
            int id = scanner.nextInt();
            for (Atleta atleta : listaAtleta)
            {
                if (atleta.getId() == id)
                {
                    String nome=atleta.getNome();
                    String cognome=atleta.getCognome();
                    LocalDate dataNascita=atleta.getDataNascita();
                    int altezza=atleta.getAltezza();
                    int idSport=atleta.getIdSport();
                    Sport sport=atleta.getSport();

                    System.out.println("Scegli quale parametro modificare digitando il numero");
                    System.out.println("1) NOME, attuale: " + atleta.getNome());
                    System.out.println("2) COGNOME, attuale: " + atleta.getCognome());
                    System.out.println("3) DATA DI NASCITA, attuale: " + atleta.getDataNascita());
                    System.out.println("4) ALTEZZA, attuale: " + atleta.getAltezza());
                    System.out.println("5) SPORT : " + atleta.getSport().getNomeSport());
                    System.out.println("6) TUTTI I PARAMETRI");
                    System.out.println("ALTRO TASTO) INDIETRO");
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
                        idSport = scanner.nextInt();
                        List<Sport> listaSport = sportService.readSport();
                        for (int i = 0; i < listaSport.size(); i++)
                        {
                            if (listaSport.get(i).getId() == idSport)
                            {
                                sport = listaSport.get(i);
                            }
                        }
                    }
                    else if (choiceUpdate == 6)
                    {
                        System.out.println("Scrivi il nuovo nome");
                        nome=scanner.nextLine();
                        System.out.println("Scrivi il nuovo cognome");
                        cognome=scanner.nextLine();
                        System.out.println("Scrivi la nuova data nascita (yyyy-mm-dd)");
                        dataNascita = LocalDate.parse(scanner.nextLine());
                        System.out.println("Scrivi la nuova altezza");
                        altezza=scanner.nextInt();
                        System.out.println("Digita il numero corrispondente al nuovo sport");
                        sportController.readSport(true);
                        idSport = scanner.nextInt();
                        List<Sport> listaSport = sportService.readSport();
                        for (int i = 0; i < listaSport.size(); i++)
                        {
                            if (listaSport.get(i).getId() == idSport)
                            {
                                sport = listaSport.get(i);
                            }
                        }
                    }
                    else
                    {
                        System.out.println("\nINDIETRO \n");
                        break;
                    }
                    scanner.nextLine();
                    System.out.println("\nMODIFICA EFFETTUATA");
                    atletaService.updateAtleta(id,nome,cognome,dataNascita,altezza,sport,idSport,choiceUpdate);
                    System.out.println("\npremere un tasto per continuare\n");
                    tasto=scanner.nextLine();
                }
            }
        }
    }
}
