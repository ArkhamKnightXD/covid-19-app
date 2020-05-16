package arkham.knight.covid.services;

import arkham.knight.covid.models.CoronaVirus;
import arkham.knight.covid.repositories.CoronaVirusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CoronaVirusService {

    @Autowired
    private CoronaVirusRepository coronaVirusRepository;


    public List<CoronaVirus> FindAllData(){

        return coronaVirusRepository.findAll();
    }


    public List<CoronaVirus> FindAllWithPaginationAndSorting(int sizeOfCasesToShow, String identifier){

        // parametro necesario para hacer la paginacion y ordenar de forma descendente por casos nuevos confirmados
        Pageable pageSortByNewConfirmed = PageRequest.of(0, sizeOfCasesToShow, Sort.by(identifier).descending());

        return coronaVirusRepository.findByCountryNotNull(pageSortByNewConfirmed);
    }


    public List<CoronaVirus> FindAllSortByTotalCases(){

        return coronaVirusRepository.findAll(Sort.by("totalConfirmed").descending());
    }


    public CoronaVirus FindByCountry(String country){

        return coronaVirusRepository.findByCountry(country);
    }


    public List<CoronaVirus> FindByCountryNameLike(String country){

        return coronaVirusRepository.findByCountryLike("%"+country+"%");
    }


    public String GetTotalConfirmedCasesWorldwide(){

        String result;

        int totalConfirmedCasesInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            totalConfirmedCasesInTheWorld += corona.getTotalConfirmed();
        }

        result = Integer.toString(totalConfirmedCasesInTheWorld);

        return result;
    }


    public int GetNewConfirmedCasesWorldwide(){

        int newConfirmedCasesInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            newConfirmedCasesInTheWorld += corona.getNewConfirmed();
        }

        return newConfirmedCasesInTheWorld;
    }


    public String GetTotalDeathsWorldwide(){

        String result;

        int totalDeathsInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            totalDeathsInTheWorld += corona.getTotalDeaths();

        }

        result = Integer.toString(totalDeathsInTheWorld);

        return result;
    }


    public int GetNeDeathsWorldwide(){

        int newDeathsInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            newDeathsInTheWorld += corona.getNewDeaths();

        }
        return newDeathsInTheWorld;
    }


    public String GetTotalRecoveredWorldwide(){

        String result;

        int totalRecoveredInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            totalRecoveredInTheWorld += corona.getTotalRecovered();

        }

        result = Integer.toString(totalRecoveredInTheWorld);

        return result;
    }


    public int GetNewRecoveredWorldwide(){

        int newRecoveredInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            newRecoveredInTheWorld += corona.getNewRecovered();

        }
        return newRecoveredInTheWorld;
    }


    public float GetCoronaVirusMortalityRate(){

        float mortalityRate;

        float totalConfirmedCasesInTheWorld = 0;

        float totalDeathsInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            totalConfirmedCasesInTheWorld += corona.getTotalConfirmed();
        }

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            totalDeathsInTheWorld += corona.getTotalDeaths();

        }

        mortalityRate = (totalDeathsInTheWorld / totalConfirmedCasesInTheWorld) * 100;

        return mortalityRate;
    }


    public void SaveAllData(List<CoronaVirus> coronaVirusListToSave){

        coronaVirusRepository.saveAll(coronaVirusListToSave);
    }
}
