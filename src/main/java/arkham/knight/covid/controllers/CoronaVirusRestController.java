package arkham.knight.covid.controllers;

import arkham.knight.covid.models.CoronaVirus;
import arkham.knight.covid.services.CoronaVirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CoronaVirusRestController {

    @Autowired
    private CoronaVirusService coronaVirusService;


    @GetMapping("/request")
    public List<CoronaVirus> GetAllData() {



        return coronaVirusService.FindAllData();
    }


    @PutMapping("/save")
    public String AddData(@RequestBody List<CoronaVirus> coronaVirusList) {



        return "data saved";
    }
}
