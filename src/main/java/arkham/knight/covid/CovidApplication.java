package arkham.knight.covid;

import arkham.knight.covid.models.CoronaVirus;
import arkham.knight.covid.services.CoronaVirusService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CovidApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(CoronaVirusService coronaVirusService){
        return args -> {

            //System.out.println(coronaVirusService.GetRecoveredCasesRateWorldwide());

/*            ObjectMapper mapper = new ObjectMapper();

            TypeReference<List<CoronaVirus>> typeReference = new TypeReference<List<CoronaVirus>>(){};

            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data.json");

            try {
                List<CoronaVirus> coronaVirusList = mapper.readValue(inputStream,typeReference);

                coronaVirusService.SaveAllData(coronaVirusList);

                System.out.println("Data Saved!");

            } catch (IOException e){

                System.out.println("Unable to save data: " + e.getMessage());
            }
*/
        };
    };
}
