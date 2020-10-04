package mainProject.trip;

import lombok.Data;
import mainProject.BaseEntity;
import mainProject.airport.Airport;
import mainProject.city.City;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Start_Location")
public class StartLocation extends BaseEntity {
    @ManyToOne
    private City city;
    @ManyToOne
    private Airport airport;
    private Long startLocationId;

}
