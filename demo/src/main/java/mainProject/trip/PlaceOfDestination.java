package mainProject.trip;

import lombok.Data;
import mainProject.airport.Airport;
import mainProject.city.City;
import mainProject.hotel.Hotel;

import javax.persistence.Entity;

@Data
@Entity
public class PlaceOfDestination {
    private City city;
    private Hotel hotel;
    private Airport airport;
}
