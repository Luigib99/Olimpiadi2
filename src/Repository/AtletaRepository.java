package Repository;
import Config.DbConnection;
import Entity.Atleta;
import Entity.Sport;
import java.util.ArrayList;
import java.sql.*;

public class AtletaRepository {

    //CREATE
    public void createAtleta(Atleta atleta) {
        String query =
                "INSERT INTO Atleta (idSport,nome,cognome,dataNascita,altezza) VALUES ('" + atleta.getIdSport()+"','"+ atleta.getCognome() + "','"+ atleta.getDataNascita()+"','"+atleta.getAltezza()+"')";
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
                "JOIN Sport s ON s.id = a.idSport";
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
                //creo l'istaza di atleta
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
                sport.setNumeroGiocatori(rs.getInt("numeroGiocatori"));

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
    public void updateNomeAtleta(Atleta atleta) {
        String query = "UPDATE Atleta SET " +
                "nome ='"+atleta.getNome()+ "'";

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
