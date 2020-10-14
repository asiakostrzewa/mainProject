package mainProject.trip;

import lombok.Data;
import mainProject.BaseEntity;
import mainProject.LocalDateTimeConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Trip extends BaseEntity {
    @ManyToOne
    private StartLocation startLocation;
    @ManyToOne
    private PlaceOfDestination placeOfDestination;
    @Convert(converter = LocalDateTimeConverter.class)
    private Date leaveDate;
    @Convert(converter = LocalDateTimeConverter.class)
    private Date returnDate;
    private TypeOfFoodEnum typeOfFoodEnum;
    private BigDecimal priceForAdult;
    private BigDecimal priceForChild;
    private boolean promoted;
    private Integer placesForAdult;
    private Integer placesForChild;



}
