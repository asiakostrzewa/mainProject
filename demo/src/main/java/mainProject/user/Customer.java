package mainProject.user;

import lombok.Getter;
import lombok.Setter;
import mainProject.order.Order;
import org.assertj.core.util.Lists;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@Entity
@DiscriminatorValue("C")
public class Customer extends User {

    boolean preferEmails;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> ordersList = Lists.newArrayList();
}
