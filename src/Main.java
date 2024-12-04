import Controller.AtletaController;
import Controller.QueryController;
import Controller.SportController;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        QueryController queryController = new QueryController();
        AtletaController atletaController = new AtletaController();
        SportController sportController = new SportController();

        int choice1;
        System.out.println("DATABASE OLIMPIADI 2024");
        do
        {
            System.out.println("DIGITA IL NUMERO CORRISPONDENTE ALLA SCELTA");
            System.out.println("1 SPORT");
            System.out.println("2 ATLETI");
            System.out.println("3 QUERY");
            System.out.println("4 CHIUDI PROGRAMMA");
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
                        sportController.readSport(true);
                    }
                    else if (choice2==8)
                    {
                        System.out.println("\nINDIETRO\n");
                        choice1=0;
                    }
                    else if (choice2==9)
                    {
                        System.out.println("\nUSCENDO\n");
                        choice1=4;
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
                        atletaController.readAtleta(true);
                    }
                    else if (choice2==8)
                    {
                        System.out.println("\nINDIETRO\n");
                        choice1=0;
                    }
                    else if (choice2==9)
                    {
                        System.out.println("\nUSCENDO\n");
                        choice1=4;
                    }
                }
                while (choice1 == 2);
            }

            else if (choice1 == 3)
            {
                System.out.println("\n++QUERY++\n");
                do
                {
                    System.out.println("DIGITA IL NUMERO CORRISPONDENTE");
                    System.out.println("1 visualizza sport di squadra");
                    System.out.println("2 visualizza i tennisti nati dopo il 2000");
                    System.out.println("3 gli atleti dello sport indicato");
                    System.out.println("4 il numero di atleti dello sport indicato");
                    System.out.println("5 il numero di sport con piu di due atleti salvati");
                    System.out.println("6 i nomi degli atleti che sono più alti della media");
                    System.out.println("8 indietro al menu iniziale");
                    System.out.println("9 chiudi programma");

                    int choice2 = scanner.nextInt();
                    if (choice2==1)
                    {
                        queryController.query1();
                    }

                    else if (choice2==2)
                    {
                        queryController.query2();
                    }

                    else if (choice2==3)
                    {
                        queryController.query3();
                    }

                    else if (choice2==4)
                    {
                        queryController.query4();
                    }

                    else if (choice2==5)
                    {
                        queryController.query5();
                    }

                    else if (choice2==6)
                    {
                        queryController.query6();
                    }

                    else if (choice2==8)
                    {
                        System.out.println("\nINDIETRO\n");
                        choice1=0;
                    }

                    else if (choice2==9)
                    {
                        System.out.println("\nUSCENDO\n");
                        choice1=4;
                    }
                }
                while (choice1 == 3);
            }
        }
        while (choice1!=4);
        scanner.close();
    }
}