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

        int totalConfirmedCasesInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            totalConfirmedCasesInTheWorld += corona.getTotalConfirmed();
        }

        // al final convierto a string debido a que la grafica que se trabaja con chart.js no reconoce los int ni floats
        // pero si le mando string lo trabaja de forma normal como si fueran numeros, aunque tambien tiene que ver con que
        // estos son datos que no se estan guardando en un objeto de una clases y por esa razon es necesario pasarlo a sting
        // pues con otros int que estan guardados en objeto no me pasa eso
        return Integer.toString(totalConfirmedCasesInTheWorld);
    }


    public String GetNewConfirmedCasesWorldwide(){

        int newConfirmedCasesInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            newConfirmedCasesInTheWorld += corona.getNewConfirmed();
        }

        return Integer.toString(newConfirmedCasesInTheWorld);
    }


    public String GetTotalDeathsWorldwide(){

        int totalDeathsInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            totalDeathsInTheWorld += corona.getTotalDeaths();

        }

        return Integer.toString(totalDeathsInTheWorld);
    }


    public String GetNewDeathsWorldwide(){

        int newDeathsInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            newDeathsInTheWorld += corona.getNewDeaths();

        }

        return Integer.toString(newDeathsInTheWorld);
    }


    public String GetTotalRecoveredWorldwide(){

        int totalRecoveredInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            totalRecoveredInTheWorld += corona.getTotalRecovered();

        }

        return Integer.toString(totalRecoveredInTheWorld);
    }


    public String GetNewRecoveredWorldwide(){

        int newRecoveredInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            newRecoveredInTheWorld += corona.getNewRecovered();

        }

        return Integer.toString(newRecoveredInTheWorld);
    }


    public String GetCoronaVirusMortalityRate(){

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


        // Aqui convierto a string de forma diferente ya que deseo que solo se muestren 2 decimales despues del punto
        return String.format ("%.2f", mortalityRate);
    }


    public void SaveAllData(List<CoronaVirus> coronaVirusListToSave){

        coronaVirusRepository.saveAll(coronaVirusListToSave);
    }
}
