package rzeznik.grzegorz.exotic_farm.animal.spider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoltRepository extends JpaRepository<Molt, Integer> {
}
