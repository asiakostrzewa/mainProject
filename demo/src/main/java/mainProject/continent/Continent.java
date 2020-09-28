package mainProject.continent;

import lombok.Data;
import mainProject.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Continents")
public class Continent extends BaseEntity {
    private String continentName;
}
