package rzeznik.grzegorz.exotic_farm.care;

import org.springframework.stereotype.Service;

@Service
public class CareService {

    private CareRepository careRepository;

    public void addCare(CareDTO careDTO){
        careRepository.save(Care.applyDTO(careDTO));
    }
}
