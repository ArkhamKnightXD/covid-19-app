package arkham.knight.covid.controllers;

import arkham.knight.covid.models.CoronaVirus;
import arkham.knight.covid.services.CoronaVirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dashboard")
public class CoronaVirusController {

    @Autowired
    private CoronaVirusService coronaVirusService;


    @RequestMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "") String country){

        int quantityOfCasesToShow = 4;
        String identifier = "newConfirmed";

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");

        if (country.equalsIgnoreCase("")) {
            model.addAttribute("datas", coronaVirusService.findAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));
        }

        else{
            model.addAttribute("datas", coronaVirusService.findByCountryNameLike(country));
        }

        model.addAttribute("graphics", coronaVirusService.findAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));
        model.addAttribute("firstCountry", Integer.toString(coronaVirusService.findByCountry("Brazil").getNewConfirmed()));
        model.addAttribute("secondCountry", Integer.toString(coronaVirusService.findByCountry("United States of America").getNewConfirmed()));
        model.addAttribute("thirdCountry", Integer.toString(coronaVirusService.findByCountry("India").getNewConfirmed()));
        model.addAttribute("fourthCountry", Integer.toString(coronaVirusService.findByCountry("Pakistan").getNewConfirmed()));

        return "/freemarker/adminPage";
    }


    @RequestMapping("/summary")
    public String summary(Model model, @RequestParam(defaultValue = "") String country){

        CoronaVirus coronaVirusCountryToGet = coronaVirusService.findByCountry(country);

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");

        if (country.equalsIgnoreCase("")) {

            model.addAttribute("countryName", "Mortality Rate Worldwide");
            model.addAttribute("datas", coronaVirusService.findAllSortByTotalCases());
            model.addAttribute("mortality", coronaVirusService.getCoronaVirusMortalityRate());
        }

        else{

            model.addAttribute("mortality", coronaVirusService.getCoronaVirusMortalityRateByCountry(country));
            model.addAttribute("datas", coronaVirusService.findByCountryNameLike(country));

            if (coronaVirusCountryToGet != null){

                model.addAttribute("countryName", "Mortality Rate in "+coronaVirusCountryToGet.getCountry());
            }

            else
                model.addAttribute("countryName", "Mortality Rate in ");
        }



        return "/freemarker/summary";
    }


    @RequestMapping("/recovered")
    public String recovered(Model model, @RequestParam(defaultValue = "") String country){

        CoronaVirus coronaVirusCountry = coronaVirusService.findByCountry(country);

        int quantityOfCasesToShow = 4;
        String identifier = "newRecovered";

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");
        model.addAttribute("graphics", coronaVirusService.findAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));

        model.addAttribute("firstCountry", Integer.toString(coronaVirusService.findByCountry("Brazil").getNewRecovered()));
        model.addAttribute("secondCountry", Integer.toString(coronaVirusService.findByCountry("India").getNewRecovered()));
        model.addAttribute("thirdCountry", Integer.toString(coronaVirusService.findByCountry("Russian Federation").getNewRecovered()));
        model.addAttribute("fourthCountry", Integer.toString(coronaVirusService.findByCountry("United States of America").getNewRecovered()));

        if (country.equalsIgnoreCase("")) {

            model.addAttribute("datas", coronaVirusService.findAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));
            model.addAttribute("countryName", "Recovered Rate Worldwide");
            model.addAttribute("recoveredRate", coronaVirusService.getRecoveredCasesRateWorldwide());
        }

        else{

            model.addAttribute("recoveredRate", coronaVirusService.getRecoveredCasesRateByCountry(country));
            model.addAttribute("datas", coronaVirusService.findByCountryNameLike(country));

            if (coronaVirusCountry != null){

                model.addAttribute("countryName", "Recovered Rate in "+coronaVirusCountry.getCountry());
            }

            else
                model.addAttribute("countryName", "Recovered Rate in ");
        }


        return "/freemarker/recovered";
    }


    @RequestMapping("/deaths")
    public String deaths(Model model, @RequestParam(defaultValue = "") String country){

        int quantityOfCasesToShow = 4;
        String identifier = "totalDeaths";

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");
        if (country.equalsIgnoreCase("")) {
            model.addAttribute("datas", coronaVirusService.findAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));
        }

        else{
            model.addAttribute("datas", coronaVirusService.findByCountryNameLike(country));
        }

        model.addAttribute("graphics", coronaVirusService.findAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));
        model.addAttribute("firstCountry", Integer.toString(coronaVirusService.findByCountry("United States of America").getTotalDeaths()));
        model.addAttribute("secondCountry", Integer.toString(coronaVirusService.findByCountry("United Kingdom").getTotalDeaths()));
        model.addAttribute("thirdCountry", Integer.toString(coronaVirusService.findByCountry("Brazil").getTotalDeaths()));
        model.addAttribute("fourthCountry", Integer.toString(coronaVirusService.findByCountry("Italy").getTotalDeaths()));


        return "/freemarker/deaths";
    }


    @RequestMapping("/worldwide")
    public String worldwide(Model model){

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");

        model.addAttribute("infected", coronaVirusService.getTotalConfirmedCasesWorldwide());

        model.addAttribute("deaths", coronaVirusService.getTotalDeathsWorldwide());

        model.addAttribute("recovered", coronaVirusService.getTotalRecoveredWorldwide());

        return "/freemarker/worldwide";
    }


    @RequestMapping("/new")
    public String newWorldwide(Model model){

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");

        model.addAttribute("infected", coronaVirusService.getNewConfirmedCasesWorldwide());

        model.addAttribute("deaths", coronaVirusService.getNewDeathsWorldwide());

        model.addAttribute("recovered", coronaVirusService.getNewRecoveredWorldwide());

        return "/freemarker/newCasesWorldwide";
    }
}
