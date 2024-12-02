import Controller.AtletaController;
import Controller.SportController;
import Entity.*;
import Service.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AtletaController atletaController = new AtletaController();
        SportController sportController = new SportController();

        int choice1;
        System.out.println("DATABASE OLIMPIADI 2024");
        do
        {
            System.out.println("DIGITA IL NUMERO CORRISPONDENTE ALLA SCELTA");
            System.out.println("1 SPORT");
            System.out.println("2 ATLETI");
            System.out.println("3 CHIUDI PROGRAMMA");
            choice1 = scanner.nextInt();

            if (choice1 == 1)
            {
                System.out.println("++SPORT++");
                do
                {
                    System.out.println("DIGITA IL NUMERO CORRISPONDENTE");
                    System.out.println("1 crea nuovo sport");
                    System.out.println("2 modifica sport esistente");
                    System.out.println("3 elimina sport esistente");
                    System.out.println("4 visualizza sport salvati");
                    System.out.println("8 torna al menu iniziale");
                    System.out.println("9 chiudi programma");
                    int choice2 = scanner.nextInt();
                    if (choice2==1)
                    {
                        sportController.createSport();
                    }
                    else if (choice2==2)
                    {
                        sportController.updateSport();
                    }
                    else if (choice2==3)
                    {
                        sportController.deleteSport();
                    }
                    else if (choice2==4)
                    {
                        sportController.readSport();
                    }
                    else if (choice2==8)
                    {
                        System.out.println("indietro");
                        choice1=0;
                    }
                    else if (choice2==9)
                    {
                        System.out.println("Uscendo");
                        choice1=3;
                    }
                }
                while (choice1 == 1);
            }

            else if (choice1 == 2)
            {
                System.out.println("++ATLETA++");
                do
                {
                    System.out.println("DIGITA IL NUMERO CORRISPONDENTE");
                    System.out.println("1 crea nuovo atleta");
                    System.out.println("2 modifica atleta esistente");
                    System.out.println("3 elimina atleta esistente");
                    System.out.println("4 visualizza atleti salvati");
                    System.out.println("8 torna al menu iniziale");
                    System.out.println("9 chiudi programma");
                    int choice2 = scanner.nextInt();
                    if (choice2==1)
                    {
                        atletaController.createAtleta();
                    }
                    else if (choice2==2)
                    {
                        atletaController.updateAtleta();
                    }
                    else if (choice2==3)
                    {
                        atletaController.deleteAtleta();
                    }
                    else if (choice2==4)
                    {
                        atletaController.readAtleta();
                    }
                    else if (choice2==8)
                    {
                        System.out.println("indietro");
                        choice1=0;
                    }
                    else if (choice2==9)
                    {
                        System.out.println("Uscendo");
                        choice1=3;
                    }
                }
                while (choice1 == 2);
            }
        }
        while (choice1!=3);
        scanner.close();
    }
}