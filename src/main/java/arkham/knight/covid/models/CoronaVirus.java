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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public int getNewConfirmed() { return newConfirmed; }

    public void setNewConfirmed(int newConfirmed) { this.newConfirmed = newConfirmed; }

    public int getTotalConfirmed() { return totalConfirmed; }

    public void setTotalConfirmed(int totalConfirmed) { this.totalConfirmed = totalConfirmed; }

    public int getNewDeaths() { return newDeaths; }

    public void setNewDeaths(int newDeaths) { this.newDeaths = newDeaths; }

    public int getTotalDeaths() { return totalDeaths; }

    public void setTotalDeaths(int totalDeaths) { this.totalDeaths = totalDeaths; }

    public int getNewRecovered() { return newRecovered; }

    public void setNewRecovered(int newRecovered) { this.newRecovered = newRecovered; }

    public int getTotalRecovered() { return totalRecovered; }

    public void setTotalRecovered(int totalRecovered) { this.totalRecovered = totalRecovered; }
}
