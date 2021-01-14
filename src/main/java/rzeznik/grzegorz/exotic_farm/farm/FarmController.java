package rzeznik.grzegorz.exotic_farm.farm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rzeznik.grzegorz.exotic_farm.animal.AnimalDTO;
import rzeznik.grzegorz.exotic_farm.animal.AnimalService;
import rzeznik.grzegorz.exotic_farm.animal.spider.speciesInfo.SpiderSpeciesInfoService;
import rzeznik.grzegorz.exotic_farm.care.CareDTO;
import rzeznik.grzegorz.exotic_farm.care.CareType;
import rzeznik.grzegorz.exotic_farm.user.UserContextService;
import rzeznik.grzegorz.exotic_farm.user.UserDTO;
import rzeznik.grzegorz.exotic_farm.user.UserService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class FarmController {

    private final FarmService farmService;
    private final AnimalService animalService;

    public FarmController(FarmService farmService, AnimalService animalService) {
        this.farmService = farmService;
        this.animalService = animalService;
    }

    @GetMapping("/farms")
    public String farmsPage(Model model) {
        List<FarmDTO> farms = farmService.findAll();
        model.addAttribute("farms", farms);
        return "farmsPage";
        //todo make user see only his farms

    }

    @PostMapping("/addFarm")
    public String addFarm(@RequestParam String farmName) {
        farmService.addFarm(new FarmDTO(farmName));
        return "redirect:/farms";
        //todo add user to the list while creating farm
    }

    @GetMapping("/farms/{id}")
    public String editFarm(@PathVariable(name = "id") Integer farmId, Model model) {
        FarmDTO farm = farmService.findById(farmId);
        List<AnimalDTO> animals = animalService.findByFarmId(farmId);
        Map<AnimalDTO, String> lastFeedingMap = findLastFeeding(animals);
        Map<AnimalDTO, String> lastRehouseMap = findLastRehouse(animals);
        Map<AnimalDTO, String> lastSubstrateChangeMap = findLastSubstrateChange(animals);
        model.addAttribute("farm", farm);
        model.addAttribute("spiderList", animals);
        model.addAttribute("careType", CareType.values());
        model.addAttribute("recentFeeding", lastFeedingMap);
        model.addAttribute("recentRehouse", lastRehouseMap);
        model.addAttribute("recentSubstrateChange", lastSubstrateChangeMap);

        return "farmEditPage";
    }

    private Map<AnimalDTO, String> findLastFeeding(List<AnimalDTO> animals) {
        Map<AnimalDTO, String> feedingMap = new HashMap<>();
        for (AnimalDTO a : animals) {
            String recentFeeding = a.getCareDTOList().stream()
                    .filter(c -> c.getType().equals(CareType.FEEDING))
                    .map(CareDTO::getDate)
                    .max(LocalDate::compareTo)
                    .map(LocalDate::toString)
                    .orElse("Never fed");
            feedingMap.put(a, recentFeeding);
        }
        return feedingMap;
    }

    private Map<AnimalDTO, String> findLastRehouse(List<AnimalDTO> animals) {
        Map<AnimalDTO, String> rehouseMap = new HashMap<>();
        for (AnimalDTO a : animals) {
            String recentFeeding = a.getCareDTOList().stream()
                    .filter(c -> c.getType().equals(CareType.REHOUSE))
                    .map(CareDTO::getDate)
                    .max(LocalDate::compareTo)
                    .map(LocalDate::toString)
                    .orElse("Never rehoused");
            rehouseMap.put(a, recentFeeding);
        }
        return rehouseMap;
    }
    private Map<AnimalDTO, String> findLastSubstrateChange(List<AnimalDTO> animals) {
        Map<AnimalDTO, String> substrateChangeMap = new HashMap<>();
        for (AnimalDTO a : animals) {
            String recentFeeding = a.getCareDTOList().stream()
                    .filter(c -> c.getType().equals(CareType.SUBSTRATE_CHANGE))
                    .map(CareDTO::getDate)
                    .max(LocalDate::compareTo)
                    .map(LocalDate::toString)
                    .orElse("Never changed");
            substrateChangeMap.put(a, recentFeeding);
        }
        return substrateChangeMap;
    }

}
