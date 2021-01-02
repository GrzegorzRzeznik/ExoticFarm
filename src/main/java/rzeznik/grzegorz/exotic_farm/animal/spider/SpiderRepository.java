package rzeznik.grzegorz.exotic_farm.animal.spider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SpiderRepository extends JpaRepository<Spider, Integer> {

    Set<Spider> findByFarmId(Integer id);
}
