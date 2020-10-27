package mainProject.trip;

import javax.persistence.*;
import lombok.Data;
import mainProject.BaseEntity;
import mainProject.airport.Airport;
import mainProject.city.City;
import mainProject.hotel.Hotel;


@Data
@Entity
@Table(name = "Place_of_destination")
public class PlaceOfDestination extends BaseEntity {
    public PlaceOfDestination(City city, Hotel hotel, Airport airport) {
        this.city = city;
        this.hotel = hotel;
        this.airport = airport;
    }

    @ManyToOne
    private City city;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private Airport airport;


    public PlaceOfDestination() {

    }
}
