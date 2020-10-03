package mainProject.cart;


import mainProject.trip.Trip;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service

public class CartService {

    public BigDecimal calculateCartPrice(Cart cart) {  //ilosc wycieczek, dorosli plus dzieci, rodzaj wyzywieniaa
        BigDecimal tripPrice = cart.getOrderLines()
                .stream()
                .map(orderLine -> {
                    Trip trip = orderLine.getTrip();
                    return trip.getPriceForAdult().multiply(new BigDecimal(orderLine.getAdultQuantity())).add(trip.getPriceForChild().multiply(new BigDecimal(orderLine.getChildQuantity())));
                }).reduce((bigDecimal, bigDecimal2) -> bigDecimal. add(bigDecimal2))
                        .orElse(BigDecimal.ZERO);
        return tripPrice;
    }


}
