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
public interface TripRepository<T extends Trip> extends JpaRepository<Trip,Long> {

    Optional<Trip> findById(Long id);

    List<T> findTripsByContinent(Continent continent);
    List<T> findTripsByCountry(Country country);
    List<T> findTripsByCity(City city);
    List<T> findTripsByHotel(Hotel hotel);


}
