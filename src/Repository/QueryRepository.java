package Repository;

import Config.DbConnection;
import Entity.*;

import java.sql.*;
import java.util.ArrayList;

public class QueryRepository {

    public ArrayList<Sport> query1() {
        ArrayList<Sport> listaSportSquadra = new ArrayList<>();
        String query =
                "SELECT nomeSport,numeroGiocatori " +
                "FROM Sport "+
                "WHERE + numeroGiocatori>1 " +
                "ORDER BY numeroGiocatori";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                //creo l'istaza di sport
                Sport sport = new Sport();

                sport.setNomeSport(rs.getString("nomeSport"));
                sport.setNumeroGiocatori(rs.getInt("numeroGiocatori"));
                listaSportSquadra.add(sport);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaSportSquadra;
    }

    public ArrayList<Atleta> query2()
    {
        ArrayList<Atleta> listaTennistiMillenial = new ArrayList<>();
        String query =
                "SELECT a.nome,a.cognome, a.dataNascita " +
                        "FROM Atleta a "+
                        "JOIN Sport s ON a.idSport=s.id "+
                        "WHERE s.nomeSport='Tennis' AND a.dataNascita>'1999-12-31'";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Atleta atleta = new Atleta();
                atleta.setNome(rs.getString("nome"));
                atleta.setCognome(rs.getString("cognome"));
                Date dataNascita = rs.getDate("dataNascita");
                if (dataNascita != null)
                {
                    atleta.setDataNascita(dataNascita.toLocalDate());
                }

                listaTennistiMillenial.add(atleta);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaTennistiMillenial;
    }

    public ArrayList<Atleta> query3(int choice3)
    {
        ArrayList<Atleta> listaAtletiSport = new ArrayList<>();
        String query =
                "SELECT a.nome,a.cognome " +
                        "FROM Atleta a "+
                        "JOIN Sport s ON a.idSport=s.id "+
                        "WHERE s.id ='"+choice3+"'";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Atleta atleta = new Atleta();
                atleta.setNome(rs.getString("nome"));
                atleta.setCognome(rs.getString("cognome"));
                listaAtletiSport.add(atleta);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaAtletiSport;
    }

    public ArrayList<Sport> query4(int choice3)
    {
        ArrayList<Sport> listaNumeroAtletiSport = new ArrayList<>();
        String query =
                "SELECT s.nomeSport, COUNT (a.nome) AS numeroAtleti " +
                        "FROM Atleta a "+
                        "JOIN Sport s ON a.idSport=s.id "+
                        "WHERE s.id ='"+choice3+"' " +
                        "GROUP BY s.nomeSport";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Sport sport = new Sport();
                sport.setNomeSport(rs.getString("nomeSport"));
                listaNumeroAtletiSport.add(sport);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaNumeroAtletiSport;
    }

    public ArrayList<Sport> query5()
    {
        ArrayList<Sport> listaSportConGiocatori = new ArrayList<>();
        String query =
                "SELECT s.nomeSport, COUNT (a.nome) AS numeroAtleti " +
                        "FROM Atleta a "+
                        "JOIN Sport s ON a.idSport=s.id "+
                        "GROUP BY s.nomeSport " +
                        "HAVING COUNT (a.nome)>=2";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Sport sport = new Sport();
                sport.setNomeSport(rs.getString("nomeSport"));
                listaSportConGiocatori.add(sport);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaSportConGiocatori;
    }

    public ArrayList<Atleta> query6()
    {
        ArrayList<Atleta> listaAtletiAlti = new ArrayList<>();
        String query =
                "SELECT nome,cognome,altezza " +
                        "FROM Atleta "+
                        "WHERE altezza>(SELECT AVG(altezza) "+
                                        "FROM Atleta) ";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                Atleta atleta = new Atleta();
                atleta.setNome(rs.getString("nome"));
                atleta.setCognome(rs.getString("cognome"));
                atleta.setAltezza(rs.getInt("altezza"));
                listaAtletiAlti.add(atleta);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaAtletiAlti;
    }


}
