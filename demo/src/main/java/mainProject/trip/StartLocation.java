package mainProject.trip;

import lombok.Data;
import mainProject.airport.Airport;
import mainProject.city.City;

import javax.persistence.Entity;

@Data
public class StartLocation {
    private City city;
    private Airport airport;

}
