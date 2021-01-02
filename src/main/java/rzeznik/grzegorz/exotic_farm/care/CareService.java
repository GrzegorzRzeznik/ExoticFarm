package rzeznik.grzegorz.exotic_farm.care;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CareService {

    @Autowired
    private CareRepository careRepository;

    public void addCare(CareDTO careDTO){
        careRepository.save(Care.applyDTO(careDTO));
    }
}
