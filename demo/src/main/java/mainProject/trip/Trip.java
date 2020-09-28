package mainProject.trip;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
public class Trip {
    private StartLocation startLocation;
    private PlaceOfDestination placeOfDestination;
    private String leaveDate;
    private String returnDate;
    private Integer howManyDays;
    private TypeOfFoodEnum typeOfFoodEnum;
    private BigDecimal priceForAdult;
    private BigDecimal priceForChild;
    private boolean promoted;
    private Integer placesForAdult;
    private Integer placesForChild;

}
