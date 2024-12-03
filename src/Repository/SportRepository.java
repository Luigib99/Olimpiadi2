package Repository;
import Config.DbConnection;
import Entity.Atleta;
import Entity.Sport;
import java.util.ArrayList;
import java.sql.*;

public class SportRepository {

    //CREATE
    public void createSport(Sport sport) {
        String query =
                "INSERT INTO Sport (nomeSport,numeroGiocatori) VALUES ('"+ sport.getNomeSport()+"','"+ sport.getNumeroGiocatori()+"')";
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
    public ArrayList<Sport> readSport() {
        ArrayList<Sport> listaSport = new ArrayList<>();
        String query =
                "SELECT * FROM Sport ORDER BY id";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                //creo l'istaza di sport
               Sport sport = new Sport();

                sport.setId(rs.getInt("id"));
                sport.setNomeSport(rs.getString("nomeSport"));
                sport.setNumeroGiocatori(rs.getInt("numeroGiocatori"));
                listaSport.add(sport);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaSport;
    }


    //DELETE
    public void deleteSport (Sport sport) {
        String query = "DELETE FROM Sport WHERE id = '" + sport.getId() + "'";

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

    public void updateSport(Sport sport, int ChoiceUpdate) {
        String query;
            if(ChoiceUpdate==1)
            {
                query = "UPDATE Sport SET " +
                        "nomeSport ='"+sport.getNomeSport()+ "' "+
                        "WHERE id = " + sport.getId();
            }
            else if (ChoiceUpdate==2)
            {
                query = "UPDATE Sport SET " +
                        "numeroGiocatori ='"+sport.getNumeroGiocatori()+ "' "+
                        "WHERE id = " + sport.getId();
            }
            else
            {
                query = "UPDATE Sport SET " +
                        "nomeSport ='"+sport.getNomeSport()+ "', "+
                        "numeroGiocatori ='"+sport.getNumeroGiocatori()+ "' "+
                        "WHERE id = " + sport.getId();
            }

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
}

