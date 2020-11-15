package mainProject.trip;

import lombok.Data;
import mainProject.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
public class Trip extends BaseEntity {
    @ManyToOne(cascade= CascadeType.PERSIST)
    private StartLocation startLocation;
    @ManyToOne(cascade= CascadeType.PERSIST)
    private PlaceOfDestination placeOfDestination;
    private String arriveDate;
    private String returnDate;
    //private Integer howManyDays;
    private TypeOfFoodEnum typeOfFoodEnum;
    private BigDecimal priceForAdult;
    private BigDecimal priceForChild;
    private boolean promoted;
    private Integer placesForAdult;
    private Integer placesForChild;

//    private BigDecimal tripPrice;

}
