package arkham.knight.covid;

import arkham.knight.covid.models.CoronaVirus;
import arkham.knight.covid.services.CoronaVirusService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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

            TypeReference<List<CoronaVirus>> typeReference = new TypeReference<List<CoronaVirus>>(){};

            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data.json");

            coronaVirusService.saveAllData(inputStream,typeReference);
        };
    };
}
