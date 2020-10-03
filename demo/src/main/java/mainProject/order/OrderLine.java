package mainProject.order;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mainProject.BaseEntity;
import mainProject.trip.Trip;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@ToString
@Table(name = "order_lines")
public class OrderLine extends BaseEntity implements Serializable {

    @OneToOne
    private Trip trip;

    private Integer adultQuantity;
    private Integer childQuantity;



    @Column(name = "trip_price")
    private BigDecimal tripPrice;
}
