package mainProject.city;

import lombok.Data;
import mainProject.BaseEntity;
import mainProject.country.Country;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Cities")
public class City extends BaseEntity {
    private String cityName;
    @ManyToOne
    private Country country;
}
