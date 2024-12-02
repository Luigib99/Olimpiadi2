package Entity;

import java.time.LocalDate;

public class Atleta {
    private int id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private int altezza;
    private int idSport;
    private Sport sport;

    public Atleta()
    {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.altezza = altezza;
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

    //NOME
    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    //COGNOME
    public String getCognome()
    {
        return cognome;
    }
    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }

    //DATA NASCITA
    public LocalDate getDataNascita ()
    {
        return dataNascita;
    }
    public void setDataNascita (LocalDate dataNascita)
    {
        this.dataNascita = dataNascita;
    }

    //ID SPORT
    public int getIdSport ()
    {
        return idSport;
    }
    public void setIdSport(int idSport)
    {
        this.idSport = idSport;
    }

    //ALTEZZA
    public int getAltezza()
    {
        return altezza;
    }
    public void setAltezza(int Altezza)
    {
        this.altezza = Altezza;
    }

    //SPORT
    public Sport getSport ()
    {
        return sport;
    }
    public void setSport(Sport sport)
    {
        this.sport = sport;
    }
}


