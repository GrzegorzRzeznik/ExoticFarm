package rzeznik.grzegorz.exotic_farm.farm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FarmService {

    @Autowired
    private FarmRepository farmRepository;

    public void addFarm(FarmDTO farmDTO){
        Farm farm = Farm.applyDTO(farmDTO);
        farmRepository.save(farm);
    }

    public List<FarmDTO> findAll(){
        return farmRepository.findAll().stream()
                .map(f -> f.toDTO())
                .collect(Collectors.toList());
    }

    public FarmDTO findById(Integer id){
        return farmRepository.findById(id)
                .map(f -> f.toDTO())
                .orElseThrow(() -> new FarmNotFoundException(id));
    }

}
