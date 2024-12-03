package Repository;
import Config.DbConnection;
import Controller.AtletaController;
import Entity.Atleta;
import Entity.Sport;
import java.util.ArrayList;
import java.sql.*;

public class AtletaRepository {

    //CREATE
    public void createAtleta(Atleta atleta) {
        String query =
                "INSERT INTO Atleta (idSport,nome,cognome,dataNascita,altezza) VALUES ('" + atleta.getIdSport()+"','"+ atleta.getNome() + "','"+ atleta.getCognome() + "','"+ atleta.getDataNascita()+"','"+atleta.getAltezza()+"')";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            stmt.execute(query);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    //READ
    public ArrayList<Atleta> readAtleta() {
        ArrayList<Atleta> listaAtleti = new ArrayList<>();
        String query =
                "SELECT a.id,a.nome,a.cognome,a.altezza,a.dataNascita, s.nomeSport "+
                "FROM Atleta a "+
                "JOIN Sport s ON s.id = a.idSport "+
                "ORDER BY a.id ASC";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                //creo l'istanza di atleta
                Atleta atleta = new Atleta();

                atleta.setId(rs.getInt("id"));
                atleta.setNome(rs.getString("nome"));
                atleta.setCognome(rs.getString("cognome"));
                atleta.setAltezza(rs.getInt("altezza"));
                Date dataNascita = rs.getDate("dataNascita");
                if (dataNascita != null)
                {
                    atleta.setDataNascita(dataNascita.toLocalDate());
                }
                //creo l'istanza di sport
                Sport sport = new Sport();

                sport.setId(rs.getInt("id"));
                sport.setNomeSport(rs.getString("nomeSport"));

                atleta.setSport(sport);
                listaAtleti.add(atleta);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaAtleti;
    }


    //DELETE
    public void deleteAtleta(Atleta atleta) {
        String query = "DELETE FROM Atleta WHERE id = '" + atleta.getId() + "'";

        try
        {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            stmt.execute(query);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    //UPDATE
    public void updateAtleta(Atleta atleta, int choiceUpdate) {
        String query;

        if (choiceUpdate==1)
        {
            query = "UPDATE Atleta SET " +
                    "nome = '" + atleta.getNome() + "' " +
                    "WHERE id = "  + atleta.getId();
        }
        else if (choiceUpdate==2)
        {
            query = "UPDATE Atleta SET " +
                    "cognome ='"+atleta.getCognome()+ "'"+
                    "WHERE id = " + atleta.getId();
        }
        else if (choiceUpdate==3)
        {
            query = "UPDATE Atleta SET " +
                    "dataNascita ='"+atleta.getDataNascita()+ "'" +
                    "WHERE id = " + atleta.getId();
        }
        else if (choiceUpdate==4)
        {
            query = "UPDATE Atleta SET " +
                    "altezza ="+atleta.getAltezza() + " "+
                    "WHERE id = " + atleta.getId();
        }
        else if (choiceUpdate==5)
        {
            query = "UPDATE Atleta SET " +
                    "idSport = "+atleta.getIdSport() + " " +
                    "WHERE id = " + atleta.getId();
        }
        else
        {
            query = "UPDATE Atleta SET " +
                    "nome='"+atleta.getNome()+ "' ," +
                    "cognome='"+atleta.getCognome()+ "' ,"+
                    "dataNascita='"+atleta.getDataNascita()+"' ,"+
                    "altezza="+atleta.getAltezza()+ " ," +
                    "idSport = "+atleta.getIdSport() + " " +
                    "WHERE id = " + atleta.getId();
        }

        try
        {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            stmt.execute(query);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
