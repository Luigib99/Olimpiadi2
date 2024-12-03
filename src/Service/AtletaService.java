package Service;
import Entity.Atleta;
import Entity.Sport;
import Repository.AtletaRepository;
import java.time.LocalDate;
import java.util.List;

public class AtletaService {
    //istanziamo la repository
    AtletaRepository atletaRepository = new AtletaRepository();

    //CREATE
    public void createAtleta(int idSport, String nome, String cognome, LocalDate dataNascita, int altezza, Sport sport)
    {
        //istanziamo l'atleta
        Atleta atleta = new Atleta();

        //mettiamo i parametri necessari affinche la repository funzioni
        atleta.setIdSport(idSport);
        atleta.setNome(nome);
        atleta.setCognome(cognome);
        atleta.setDataNascita(dataNascita);
        atleta.setAltezza(altezza);
        atleta.setSport(sport);
        atletaRepository.createAtleta(atleta);
    }

    //READ
    public List <Atleta> readAtleta()
    {
        return atletaRepository.readAtleta();
    }

    //DELETE
    public void deleteAtleta(int idAtleta)
    {
        //istanziamo l'atleta
        Atleta atleta =  new Atleta();

        //mettiamo i parameti necessari
        atleta.setId(idAtleta);
        atletaRepository.deleteAtleta(atleta);
    }

    //UPDATE
    public void updateAtleta(int id, String nome, String cognome, LocalDate dataNascita, int altezza, Sport sport, int idSport, int choiceUpdate)
    {
        //istanziamo l'atleta
        Atleta atleta = new Atleta();

        //mettiamo i parametri necessari
        atleta.setId(id);
        atleta.setNome(nome);
        atleta.setCognome(cognome);
        atleta.setDataNascita(dataNascita);
        atleta.setAltezza(altezza);
        atleta.setIdSport(idSport);
        atleta.setSport(sport);
        int ChoiceUpdate = choiceUpdate;
        atletaRepository.updateAtleta(atleta, ChoiceUpdate);
    }
}
