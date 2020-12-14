package rzeznik.grzegorz.exotic_farm.farm;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FarmRepository extends JpaRepository<Farm, Integer> {

    Optional<Farm> findByName(String name);
}
