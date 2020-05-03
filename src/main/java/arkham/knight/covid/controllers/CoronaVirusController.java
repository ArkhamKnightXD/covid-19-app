package arkham.knight.covid.controllers;

import arkham.knight.covid.services.CoronaVirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class CoronaVirusController {

    @Autowired
    private CoronaVirusService coronaVirusService;


    @RequestMapping("/")
    public String index(Model model){

        int quantityOfCasesToShow = 10;
        String identifier = "newConfirmed";

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");
        model.addAttribute("datas", coronaVirusService.FindAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));

        return "/freemarker/adminPage";
    }


    @RequestMapping("/summary")
    public String summary(Model model){

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");
        model.addAttribute("datas", coronaVirusService.FindAllSortByTotalCases());

        return "/freemarker/summary";
    }


    @RequestMapping("/recovered")
    public String recovered(Model model){

        int quantityOfCasesToShow = 10;
        String identifier = "newRecovered";

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");
        model.addAttribute("datas", coronaVirusService.FindAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));

        return "/freemarker/recovered";
    }


    @RequestMapping("/deaths")
    public String deaths(Model model){

        int quantityOfCasesToShow = 10;
        String identifier = "totalDeaths";

        model.addAttribute("title","Welcome to the Covid-19 Dashboard");
        model.addAttribute("datas", coronaVirusService.FindAllWithPaginationAndSorting(quantityOfCasesToShow,identifier));

        return "/freemarker/deaths";
    }
}
