package rzeznik.grzegorz.exotic_farm.animal.spider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rzeznik.grzegorz.exotic_farm.animal.Sex;
import rzeznik.grzegorz.exotic_farm.animal.Temperament;
import rzeznik.grzegorz.exotic_farm.animal.spider.speciesInfo.SpiderSpeciesInfoDTO;
import rzeznik.grzegorz.exotic_farm.animal.spider.speciesInfo.SpiderSpeciesInfoService;
import rzeznik.grzegorz.exotic_farm.farm.Farm;
import rzeznik.grzegorz.exotic_farm.farm.FarmDTO;
import rzeznik.grzegorz.exotic_farm.farm.FarmService;

import java.time.LocalDate;

@Controller
public class SpiderController {

    @Autowired
    private SpiderService spiderService;
    @Autowired
    private SpiderSpeciesInfoService spiderSpeciesInfoService;
    @Autowired
    private FarmService farmService;

//    @GetMapping("farms/{farmID}/{spiderID}")
//    public String addSpider(@PathVariable(name = "farmID") Integer farmID, @PathVariable(name = "spiderID") Integer spiderID, Model model){
//        model.addAttribute("spiderData", spiderService.findById(spiderID));
//        return "farmEditPage";
//    }

    @PostMapping("/spiders")
    public String addSpider(@RequestParam Status status,
                            @RequestParam String name,
                            @RequestParam String genus,
                            @RequestParam String species,
                            @RequestParam String acquisitionDate,
                            @RequestParam Sex sex,
                            @RequestParam Temperament temperament,
                            @RequestParam String farmID,
                            @RequestParam VenomPotency venomPotency,
                            @RequestParam Type type,
                            Model model){
        FarmDTO farmDTO = farmService.findById(Integer.parseInt(farmID));
        model.addAttribute("farm", farmDTO);
        SpiderSpeciesInfoDTO speciesInfo= spiderSpeciesInfoService.findByGenusAndSpecies(genus, species);
        LocalDate date = LocalDate.parse(acquisitionDate);
        SpiderDTO spiderDTO= new SpiderDTO(date, name, farmDTO, sex, status, temperament, venomPotency, type);
        spiderDTO.setInfoDTO(speciesInfo);
        spiderService.addSpider(spiderDTO);
        return "redirect:/farms/"+farmID;
    }
}