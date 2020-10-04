package mainProject.trip;

import lombok.Data;
import mainProject.airport.Airport;
import mainProject.city.City;
import mainProject.hotel.Hotel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class PlaceOfDestination {
    private City city;
    private Hotel hotel;
    private Airport airport;
    private Long placeOfDestinationId;

    @Id
    public Long getPlaceOfDestinationId() {
        return placeOfDestinationId;
    }
}
