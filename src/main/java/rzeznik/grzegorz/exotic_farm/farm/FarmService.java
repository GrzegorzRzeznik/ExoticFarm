package rzeznik.grzegorz.exotic_farm.farm;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FarmService {

    private final FarmRepository farmRepository;

    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    public void addFarm(FarmDTO farmDTO){
        Farm farm = Farm.applyDTO(farmDTO);
        farmRepository.save(farm);
    }

    public List<FarmDTO> findAll(){
        return farmRepository.findAll().stream()
                .map(Farm::toDTO)
                .collect(Collectors.toList());
    }

    public FarmDTO findById(Integer id){
        return farmRepository.findById(id)
                .map(Farm::toDTO)
                .orElseThrow(() -> new FarmNotFoundException(id));
    }

}
