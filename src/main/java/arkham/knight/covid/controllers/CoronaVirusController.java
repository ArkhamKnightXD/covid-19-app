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

        int quantityOfCasesToShow = 5;
        String identifier = "newConfirmed";

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");

        if (country.equalsIgnoreCase("")) {
            model.addAttribute("datas", coronaVirusService.FindAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));
        }

        else{
            model.addAttribute("datas", coronaVirusService.FindByCountryNameLike(country));
        }

        model.addAttribute("graphics", coronaVirusService.FindAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));

        return "/freemarker/adminPage";
    }


    @RequestMapping("/summary")
    public String summary(Model model, @RequestParam(defaultValue = "") String country){

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");

        if (country.equalsIgnoreCase("")) {

            model.addAttribute("countryName", "Mortality Rate Worldwide");
            model.addAttribute("datas", coronaVirusService.FindAllSortByTotalCases());
            model.addAttribute("mortality", coronaVirusService.GetCoronaVirusMortalityRate());
        }

        else{
            CoronaVirus coronaVirusCountryToGet = coronaVirusService.FindByCountry(country);

            model.addAttribute("mortality", coronaVirusService.GetCoronaVirusMortalityRateByCountry(country));
            model.addAttribute("datas", coronaVirusService.FindByCountryNameLike(country));

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

        int quantityOfCasesToShow = 5;
        String identifier = "newRecovered";

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");

        if (country.equalsIgnoreCase("")) {
            model.addAttribute("datas", coronaVirusService.FindAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));
        }

        else{
            model.addAttribute("datas", coronaVirusService.FindByCountryNameLike(country));
        }

        model.addAttribute("graphics", coronaVirusService.FindAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));

        return "/freemarker/recovered";
    }


    @RequestMapping("/deaths")
    public String deaths(Model model, @RequestParam(defaultValue = "") String country){

        int quantityOfCasesToShow = 5;
        String identifier = "totalDeaths";

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");
        if (country.equalsIgnoreCase("")) {
            model.addAttribute("datas", coronaVirusService.FindAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));
        }

        else{
            model.addAttribute("datas", coronaVirusService.FindByCountryNameLike(country));
        }

        model.addAttribute("graphics", coronaVirusService.FindAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));

        return "/freemarker/deaths";
    }


    @RequestMapping("/worldwide")
    public String worldwide(Model model){

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");

        model.addAttribute("infected", coronaVirusService.GetTotalConfirmedCasesWorldwide());

        model.addAttribute("deaths", coronaVirusService.GetTotalDeathsWorldwide());

        model.addAttribute("recovered", coronaVirusService.GetTotalRecoveredWorldwide());

        return "/freemarker/worldwide";
    }


    @RequestMapping("/new")
    public String newWorldwide(Model model){

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");

        model.addAttribute("infected", coronaVirusService.GetNewConfirmedCasesWorldwide());

        model.addAttribute("deaths", coronaVirusService.GetNewDeathsWorldwide());

        model.addAttribute("recovered", coronaVirusService.GetNewRecoveredWorldwide());

        return "/freemarker/newCasesWorldwide";
    }
}
