package mainProject.country;

import lombok.Data;
import mainProject.BaseEntity;
import mainProject.continent.Continent;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Countries")
public class Country extends BaseEntity {
    private String countryName;
    @ManyToOne
    private Continent continent;
}
