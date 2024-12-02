package Entity;

public class Sport {
    private int id;
    private String nomeSport;
    private int numeroGiocatori;
    public Sport()
    {
        this.id = id;
        this.nomeSport = nomeSport;
        this.numeroGiocatori = numeroGiocatori;
    }

    //ID
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    //NOME SPORT
    public String getNomeSport(){return nomeSport;}
    public void setNomeSport(String nomeSport)
    {
        this.nomeSport = nomeSport;
    }

    //NUMERO GIOCATORI
    public int getNumeroGiocatori(){return numeroGiocatori;}
    public void setNumeroGiocatori(int numeroGiocatori)
    {
        this.numeroGiocatori = numeroGiocatori;
    }
}
