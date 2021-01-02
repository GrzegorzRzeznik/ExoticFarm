package rzeznik.grzegorz.exotic_farm.farm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rzeznik.grzegorz.exotic_farm.animal.Sex;
import rzeznik.grzegorz.exotic_farm.animal.Temperament;
import rzeznik.grzegorz.exotic_farm.animal.spider.*;
import rzeznik.grzegorz.exotic_farm.animal.spider.speciesInfo.SpiderSpeciesInfoDTO;
import rzeznik.grzegorz.exotic_farm.animal.spider.speciesInfo.SpiderSpeciesInfoService;

import java.util.List;
import java.util.Set;

@Controller
public class FarmController {

    @Autowired
    private FarmService farmService;
    @Autowired
    private SpiderSpeciesInfoService spiderSpeciesInfoService;
    @Autowired
    private SpiderService spiderService;

    @GetMapping("/farms")
    public String farmsPage(Model model) {
        List<FarmDTO> farms = farmService.findAll();
        model.addAttribute("farms", farms);
        return "farmsPage";
    }

    @PostMapping("/addFarm")
    public String addFarm(@RequestParam String farmName) {
        farmService.addFarm(new FarmDTO(farmName));
        return "redirect:/farms";
    }

    @GetMapping("/farms/{id}")
    public String editForm(@PathVariable(name = "id") Integer farmId, Model model) {
        FarmDTO farm = farmService.findById(farmId);
        Set<SpiderDTO> spiders = spiderService.findByFarmId(farmId);
        final List<SpiderSpeciesInfoDTO> spiderSpeciesInfoDTOS = spiderSpeciesInfoService.findAll();
        model.addAttribute("farm", farm);
        model.addAttribute("statusList", Status.values());
        model.addAttribute("sexList", Sex.values());
        model.addAttribute("temperamentList", Temperament.values());
        model.addAttribute("typeList", Type.values());
        model.addAttribute("venomPotencyList", VenomPotency.values());
        model.addAttribute("spiderList", spiders);
        model.addAttribute("speciesInfo", spiderSpeciesInfoDTOS);
        return "farmEditPage";
    }

}
