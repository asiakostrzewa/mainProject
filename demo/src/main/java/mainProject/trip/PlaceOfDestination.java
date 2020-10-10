package mainProject.trip;

import javax.persistence.*;
import lombok.Data;
import mainProject.BaseEntity;
import mainProject.airport.Airport;
import mainProject.city.City;
import mainProject.hotel.Hotel;


@Data
@Entity
public class PlaceOfDestination extends BaseEntity {

    @ManyToOne
    private City city;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private Airport airport;

}
