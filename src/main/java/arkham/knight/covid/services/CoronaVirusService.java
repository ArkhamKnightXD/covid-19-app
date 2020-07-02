package arkham.knight.covid.services;

import arkham.knight.covid.models.CoronaVirus;
import arkham.knight.covid.repositories.CoronaVirusRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class CoronaVirusService {

    @Autowired
    private CoronaVirusRepository coronaVirusRepository;


    public List<CoronaVirus> findAllData(){

        return coronaVirusRepository.findAll();
    }


    public List<CoronaVirus> findAllWithPaginationAndSorting(int sizeOfCasesToShow, String identifier){

        // parametro necesario para hacer la paginacion y ordenar de forma descendente por casos nuevos confirmados
        Pageable pageSortByNewConfirmed = PageRequest.of(0, sizeOfCasesToShow, Sort.by(identifier).descending());

        return coronaVirusRepository.findByCountryNotNull(pageSortByNewConfirmed);
    }


    public List<CoronaVirus> findAllSortByTotalCases(){

        return coronaVirusRepository.findAll(Sort.by("totalConfirmed").descending());
    }


    public CoronaVirus findByCountry(String country){

        return coronaVirusRepository.findByCountry(country);
    }


    public List<CoronaVirus> findByCountryNameLike(String country){

        // Las "%" significa que no es necesario que se pongan todos los caracteres correctamente
        return coronaVirusRepository.findByCountryLike("%"+country+"%");
    }


    public String getTotalConfirmedCasesWorldwide(){

        int totalConfirmedCasesInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            totalConfirmedCasesInTheWorld += corona.getTotalConfirmed();
        }

        // al final convierto a string debido a que la grafica que se trabaja con chart.js no reconoce los int ni floats pero si le mando string lo trabaja de forma normal como
        // si fueran numeros, aunque tambien tiene que ver con que estos son datos que no se estan guardando en un objeto de una clases y por esa razon es necesario pasarlo a string
        // pues con otros int que estan guardados en objeto no me pasa eso
        return Integer.toString(totalConfirmedCasesInTheWorld);
    }


    public String getNewConfirmedCasesWorldwide(){

        int newConfirmedCasesInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            newConfirmedCasesInTheWorld += corona.getNewConfirmed();
        }

        return Integer.toString(newConfirmedCasesInTheWorld);
    }


    public String getTotalDeathsWorldwide(){

        int totalDeathsInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            totalDeathsInTheWorld += corona.getTotalDeaths();

        }

        return Integer.toString(totalDeathsInTheWorld);
    }


    public String getNewDeathsWorldwide(){

        int newDeathsInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            newDeathsInTheWorld += corona.getNewDeaths();

        }

        return Integer.toString(newDeathsInTheWorld);
    }


    public String getTotalRecoveredWorldwide(){

        int totalRecoveredInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            totalRecoveredInTheWorld += corona.getTotalRecovered();

        }

        return Integer.toString(totalRecoveredInTheWorld);
    }


    public String getNewRecoveredWorldwide(){

        int newRecoveredInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            newRecoveredInTheWorld += corona.getNewRecovered();

        }

        return Integer.toString(newRecoveredInTheWorld);
    }


    public String getCoronaVirusMortalityRate(){

        float mortalityRate;

        float totalConfirmedCasesInTheWorld = 0;

        float totalDeathsInTheWorld = 0;

        for (CoronaVirus corona: coronaVirusRepository.findAll()) {

            totalConfirmedCasesInTheWorld += corona.getTotalConfirmed();

            totalDeathsInTheWorld += corona.getTotalDeaths();
        }

        mortalityRate = (totalDeathsInTheWorld / totalConfirmedCasesInTheWorld) * 100;

        // Aqui convierto a string de forma diferente ya que deseo que solo se muestren 2 decimales despues del punto
        return String.format ("%.2f", mortalityRate);
    }


    public String getCoronaVirusMortalityRateByCountry(String countryName){

        CoronaVirus countryToCalculateMortality = coronaVirusRepository.findByCountry(countryName);

        float mortalityRate;

        if (countryToCalculateMortality != null) {

            float totalConfirmedCasesInTheCountry = countryToCalculateMortality.getTotalConfirmed();

            float totalDeathsInTheCountry = countryToCalculateMortality.getTotalDeaths();

            mortalityRate = (totalDeathsInTheCountry / totalConfirmedCasesInTheCountry) * 100;

            return String.format ("%.2f", mortalityRate);
        }

        else
            return "0";
    }


    public String getRecoveredCasesRateWorldwide(){

        float totalPercent;

        float totalConfirmedCases = 0;

        float totalRecoveredCases = 0;

        for (CoronaVirus country: coronaVirusRepository.findAll()) {

            totalConfirmedCases += country.getTotalConfirmed();

            totalRecoveredCases += country.getTotalRecovered();
        }

        totalPercent = (totalRecoveredCases/totalConfirmedCases) * 100;

        return String.format ("%.2f", totalPercent);
    }


    public String getRecoveredCasesRateByCountry(String countryName){

        CoronaVirus coronaVirusCountry = coronaVirusRepository.findByCountry(countryName);

        float totalPercent;

        float totalConfirmedCases = 0;

        float totalRecoveredCases = 0;

        if (coronaVirusCountry != null){

            totalConfirmedCases = coronaVirusCountry.getTotalConfirmed();

            totalRecoveredCases = coronaVirusCountry.getTotalRecovered();

            totalPercent = (totalRecoveredCases/totalConfirmedCases) * 100;

            return String.format ("%.2f", totalPercent);
        }

        return "0";
    }


    public void saveAllData(ObjectMapper objectMapper, InputStream inputStream, TypeReference<List<CoronaVirus>> typeReference){

        try {
            List<CoronaVirus> coronaVirusList = objectMapper.readValue(inputStream,typeReference);

            coronaVirusRepository.saveAll(coronaVirusList);

            System.out.println("Data Saved!");

        } catch (IOException e){

            System.out.println("Unable to save data: " + e.getMessage());
        }
    }
}
