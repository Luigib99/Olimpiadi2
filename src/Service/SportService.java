package Service;
import Entity.Sport;
import Repository.SportRepository;
import java.util.List;

public class SportService {
    SportRepository sportRepository = new SportRepository();

    //CREATE
    public void createSport(String nomeSport,int numeroGiocatori)
    {
        Sport sport = new Sport();
        sport.setNomeSport(nomeSport);
        sport.setNumeroGiocatori(numeroGiocatori);
        sportRepository.createSport(sport);
    }

    //READ
    public List <Sport> readSport ()
    {
        return sportRepository.readSport();
    }

    //DELETE
    public void deleteSport(int idSport)
    {
        Sport sport = new Sport();
        sport.setId(idSport);
        sportRepository.deleteSport(sport);
    }


}