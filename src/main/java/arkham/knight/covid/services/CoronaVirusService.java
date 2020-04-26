package arkham.knight.covid.services;

import arkham.knight.covid.models.CoronaVirus;
import arkham.knight.covid.repositories.CoronaVirusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CoronaVirusService {

    @Autowired
    private CoronaVirusRepository coronaVirusRepository;


    public List<CoronaVirus> FindAllData(){

        return coronaVirusRepository.findAll();
    }


    public CoronaVirus FindByCountry(String country){

        return coronaVirusRepository.findByCountry(country);
    }


    public void SaveAllData(List<CoronaVirus> coronaVirusListToSave){

        coronaVirusRepository.saveAll(coronaVirusListToSave);
    }
}
