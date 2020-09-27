package mainProject.trip;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TripDTO {

    private Long id;
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
