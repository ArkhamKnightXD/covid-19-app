package arkham.knight.covid.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoronaVirus {

    @Id
    @GeneratedValue
    private Long id;

    private String country;
    private int newConfirmed;
    private int totalConfirmed;
    private int newDeaths;
    private int totalDeaths;
    private int newRecovered;
    private int totalRecovered;


    public CoronaVirus() {
    }


    public String getCountry() { return country; }
    
    public int getNewConfirmed() { return newConfirmed; }

    public int getTotalConfirmed() { return totalConfirmed; }

    public int getNewDeaths() { return newDeaths; }

    public int getTotalDeaths() { return totalDeaths; }

    public int getNewRecovered() { return newRecovered; }

    public int getTotalRecovered() { return totalRecovered; }
}
