package mainProject.airport;

import lombok.Data;
import mainProject.BaseEntity;
import mainProject.city.City;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Airports")
public class Airport extends BaseEntity {
    private String airportName;
    @ManyToOne
    private City city;
}
