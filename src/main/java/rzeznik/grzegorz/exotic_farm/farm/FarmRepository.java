package rzeznik.grzegorz.exotic_farm.farm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FarmRepository extends JpaRepository<Farm, Integer> {

    Optional<Farm> findByName(String name);
}
