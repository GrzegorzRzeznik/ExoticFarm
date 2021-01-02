package rzeznik.grzegorz.exotic_farm.animal.spider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rzeznik.grzegorz.exotic_farm.animal.AnimalNotFoundException;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SpiderService {

    @Autowired
    private SpiderRepository spiderRepository;

    public void addSpider(SpiderDTO spiderDTO){
        spiderRepository.save(Spider.applyDTO(spiderDTO));
    }

    public SpiderDTO findById(Integer id){
        return spiderRepository.findById(id)
                .map(Spider::toDTO)
                .orElseThrow(() -> new AnimalNotFoundException(id));

    }

    public Set<SpiderDTO> findByFarmId(Integer id){
        return spiderRepository.findByFarmId(id).stream().map(Spider::toDTO).collect(Collectors.toSet());
    }
}
