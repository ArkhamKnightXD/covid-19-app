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

        model.addAttribute("title","Welcome to sentiment analyzer");
        model.addAttribute("datas", coronaVirusService.FindAllData());

        return "/freemarker/adminPage";
    }
}
