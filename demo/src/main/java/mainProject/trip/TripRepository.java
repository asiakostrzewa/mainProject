package mainProject.trip;

import mainProject.city.City;
import mainProject.continent.Continent;
import mainProject.country.Country;
import mainProject.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {

    Optional<Trip> findById(Long id);

//    List<Trip> findTripsByContinent(Continent continent);
//    List<Trip> findTripsByCountry(Country country);
//    List<Trip> findTripsByCity(City city);
//    List<Trip> findTripsByHotel(Hotel hotel);


}
