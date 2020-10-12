package mainProject.trip;

import lombok.Data;
import mainProject.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
public class Trip extends BaseEntity {
    @ManyToOne
    private StartLocation startLocation;
    @ManyToOne
    private PlaceOfDestination placeOfDestination;
    private String leaveDate;
    private String returnDate;
    private TypeOfFoodEnum typeOfFoodEnum;
    private BigDecimal priceForAdult;
    private BigDecimal priceForChild;
    private boolean promoted;
    private Integer placesForAdult;
    private Integer placesForChild;



}
