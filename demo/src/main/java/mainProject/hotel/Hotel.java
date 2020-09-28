package mainProject.hotel;

import lombok.Data;
import mainProject.BaseEntity;
import mainProject.city.City;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Hotels")
public class Hotel extends BaseEntity {
    private String hotelName;
    private Double hotelStars;
    private String hotelDescription;
    @ManyToOne
    private City city;
}
