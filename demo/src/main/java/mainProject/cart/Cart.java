package mainProject.cart;


import lombok.Getter;
import lombok.Setter;
import mainProject.order.OrderLine;
import org.assertj.core.util.Lists;

import java.util.List;

@Getter
@Setter
public class Cart {

    private List<OrderLine> orderLines = Lists.newArrayList();


}

