package mainProject.order;

import lombok.*;
import mainProject.BaseEntity;
import mainProject.LocalDateTimeConverter;
import mainProject.user.Customer;
import mainProject.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
    @Table(name = "orders")
    @ToString(exclude = "user")
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Order extends BaseEntity implements Serializable {

        private String userName;

        private BigDecimal totalCost;

        @Convert(converter = LocalDateTimeConverter.class)
        private LocalDateTime creationDate;

        @OneToMany(cascade = CascadeType.ALL)
        private List<OrderLine> orders;

        @ManyToOne
        private User user;

        @ManyToOne
        private Customer customer;

        @Enumerated(EnumType.STRING)
        private OrderStatus orderStatus;

}

