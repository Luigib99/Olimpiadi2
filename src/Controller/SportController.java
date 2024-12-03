package Controller;

import Service.*;
import Entity.*;
import java.util.*;

import java.util.Scanner;

public class SportController {
    String tasto;
    Scanner scanner = new Scanner(System.in);
    SportService sportService = new SportService();
    AtletaService atletaService = new AtletaService();

    public void createSport()
    {
        System.out.println("Inserisci il nome dello sport");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il numero di giocatori giocanti in una squadra");
        int numeroGiocatori = scanner.nextInt();
        sportService.createSport(nome, numeroGiocatori);
        System.out.println("\nSPORT CREATO\n");
        scanner.nextLine();
        System.out.println("premere un tasto per continuare");
        tasto = scanner.nextLine();
    }

    public void readSport(boolean completo)
    {
        List<Sport> listaSport = sportService.readSport();
        if (listaSport.size()==0)
        {
            System.out.println("non sono presenti sport salvati");
            scanner.nextLine();
            System.out.println("premere un tasto per continuare");
            tasto = scanner.nextLine();
        }
        else {
            if (completo) {
                for (Sport sport : listaSport) {
                    System.out.println(sport.getId() + " " +
                            sport.getNomeSport() + " " +
                            sport.getNumeroGiocatori() + " giocatore/i");
                }
                System.out.println("premere un tasto per continuare");
                tasto = scanner.nextLine();
            } else {
                for (Sport sport : listaSport) {
                    System.out.println(sport.getId() + " " +
                            sport.getNomeSport());
                }
            }
        }
    }

    public void deleteSport()
    {
        List<Sport> listaSport = sportService.readSport();

        if (listaSport.isEmpty())
        {
            System.out.println("\nnon sono presenti sport salvati");
        }
        else
        {
            System.out.println("Elimina lo sport digitando l'id: ");
            readSport(false);
            int id = scanner.nextInt();
            sportService.deleteSport(id);
            System.out.println("\nSPORT ELIMINATO");
            scanner.nextLine();
        }
        System.out.println("\npremere un tasto per continuare");
        tasto=scanner.nextLine();
    }

    public void updateSport()
    {
        List<Sport> listaSport = sportService.readSport();

        if (listaSport.isEmpty())
        {
            System.out.println("non sono presenti sport salvati");
        }
        else
        {
            System.out.println("Modifica lo sport digitando l'id: ");
            readSport(false);
            int id = scanner.nextInt();
            for (Sport sport : listaSport)
            {
                if (sport.getId() == id)
                {
                    scanner.nextLine();
                    String nomeSport = sport.getNomeSport();
                    int numeroGiocatori = sport.getNumeroGiocatori();

                    System.out.println("Scegli quale parametro modificare digitando il numero");
                    System.out.println("1) NOME, attuale: " + sport.getNomeSport());
                    System.out.println("2) NUMERO GIOCATORI, attuale: " + sport.getNumeroGiocatori());
                    System.out.println("3) TUTTI I PARAMETRI");
                    System.out.println("ALTRO TASTO) INDIETRO");

                    int choiceUpdate=scanner.nextInt();
                    scanner.nextLine();

                    if (choiceUpdate==1)
                    {
                        System.out.println("Scrivi il nuovo nome");
                        nomeSport=scanner.nextLine();
                    }
                    else if (choiceUpdate==2)
                    {
                        System.out.println("Scrivi il numero di giocatori");
                        numeroGiocatori=scanner.nextInt();
                    }
                    else if (choiceUpdate==3)
                    {
                        System.out.println("Scrivi il nuovo nome");
                        nomeSport=scanner.nextLine();
                        System.out.println("Scrivi il numero di giocatori");
                        numeroGiocatori=scanner.nextInt();
                    }
                    else
                    {
                        System.out.println("\nINDIETRO \n");
                        break;
                    }
                    scanner.nextLine();
                    System.out.println("\nMODIFICA EFFETTUATA");
                    sportService.updateSport(id,nomeSport,numeroGiocatori,choiceUpdate);
                    System.out.println("\npremere un tasto per continuare\n");
                    tasto=scanner.nextLine();
                }
            }
        }
    }
}
