package mainProject.trip;

import lombok.Data;
import mainProject.airport.Airport;
import mainProject.city.City;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Start_Location")
public class StartLocation {
    private City city;
    private Airport airport;
    private Long startLocationId;

    @Id
    public Long getStartLocationId() {
        return startLocationId;
    }
}
