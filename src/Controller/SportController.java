package Controller;

import Service.*;
import Entity.*;

import javax.swing.*;
import java.util.*;

import java.util.Scanner;

public class SportController {
    Scanner scanner = new Scanner(System.in);
    SportService sportService = new SportService();

    public void createSport()
    {
        System.out.println("Inserisci il nome dello sport");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il numero di giocatori giocanti in una squadra");
        int numeroGiocatori = scanner.nextInt();


        System.out.println("premere un tasto per continuare");
        String tasto = scanner.nextLine();

        sportService.createSport(nome, numeroGiocatori);
    }

    public void updateSport()
    {

    }

    public void readSport(boolean readAtleta)
    {
        List<Sport> listaSport = sportService.readSport();
        if (listaSport.size()==0)
        {
            System.out.println("non sono presenti sport salvati");
            System.out.println("premere un tasto per continuare");
            String tasto = scanner.nextLine();
        }
        else {
            if (readAtleta) {
                for (Sport sport : listaSport) {
                    System.out.println(sport.getId() + " " +
                            sport.getNomeSport());
                }
            }
            else
            {
                for (Sport sport : listaSport)
                {
                    System.out.println(sport.getId() + " " +
                            sport.getNomeSport() + " " +
                            sport.getNumeroGiocatori());
                }
                System.out.println("premere un tasto per continuare");
                String tasto = scanner.nextLine();
            }
        }
    }

    public void deleteSport()
    {

    }
}
