package Service;

import Repository.QueryRepository;
import Entity.*;
import java.util.List;

public class QueryService {
    QueryRepository queryRepository = new QueryRepository();

    public List<Sport> query1 ()
    {
        return queryRepository.query1();
    }

    public List<Atleta> query2()
    {
        return queryRepository.query2();
    }

    public List<Atleta> query3(int choice3)
    {
        return queryRepository.query3(choice3);
    }

}
