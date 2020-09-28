package mainProject.airport;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AirportRepository  extends JpaRepository<Airport,Long>{
}
