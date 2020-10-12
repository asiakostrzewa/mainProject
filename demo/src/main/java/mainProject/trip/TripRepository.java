package mainProject.trip;

import mainProject.city.City;
import mainProject.continent.Continent;
import mainProject.country.Country;
import mainProject.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long>, JpaSpecificationExecutor<Trip> {

    Optional<Trip> findById(Long id);
    List<Trip> getAllTrips();
    Trip getTripInfo(Long id);
    List<Trip> findTrip();


}
