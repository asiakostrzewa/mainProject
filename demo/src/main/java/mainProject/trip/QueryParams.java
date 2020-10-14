package mainProject.trip;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class QueryParams {
    StartLocation startLocation;
    PlaceOfDestination placeOfDestination;
    String leaveDate;
    String returnDate;
    TypeOfFoodEnum typeOfFoodEnum;
    BigDecimal priceForAdult;
    BigDecimal priceForChild;
    Boolean promoted;
    Integer placesForAdult;
    Integer placesForChild;
}
