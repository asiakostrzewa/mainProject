package mainProject.trip;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class TripDTO {

    private Long id;
    private StartLocation startLocation;
    private PlaceOfDestination placeOfDestination;
    private Date leaveDate;
    private Date returnDate;
    private TypeOfFoodEnum typeOfFoodEnum;
    private BigDecimal priceForAdult;
    private BigDecimal priceForChild;
    private Boolean promoted;
    private Integer placesForAdult;
    private Integer placesForChild;
}
