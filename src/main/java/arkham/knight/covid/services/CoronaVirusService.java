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


    public void SaveAllData(List<CoronaVirus> coronaVirusListToSave){

        coronaVirusRepository.saveAll(coronaVirusListToSave);
    }
}
