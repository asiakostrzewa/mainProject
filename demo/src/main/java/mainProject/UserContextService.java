package mainProject;

import com.google.gson.Gson;
import lombok.Getter;
import mainProject.cart.Cart;
import mainProject.order.OrderLine;
import mainProject.trip.Trip;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Optional;


@Service
@SessionScope
public class UserContextService {


    @Getter
    private Cart cart = new Cart();

    private static Gson gson = new Gson();

   public String getLoggedUserEmail() {

        return null;
    }


    public boolean admin() {

        return false;
    }

    public boolean user() {

        return false;
    }

    public String getCartAsJson() {
        return gson.toJson(cart);
    }


    public void addProductToCart(Trip trip) {
        List<OrderLine> orderLines = cart.getOrderLines();
        Optional<OrderLine> first = orderLines.stream().filter(e -> e.getTrip().getId().equals(trip.getId())).findFirst();
        if (first.isPresent()) {
            first.get().setAdultQuantity(first.get().getAdultQuantity() + 1);
            first.get().setChildQuantity(first.get().getChildQuantity() +1);
        } else {
            OrderLine orderLine = new OrderLine();
            orderLine.setTrip(trip);
            orderLine.setTripPrice(trip.getPriceForAdult().add(trip.getPriceForChild()));
            orderLine.setAdultQuantity(1);
            orderLine.setChildQuantity(1);
            orderLines.add(orderLine);
        }
    }

    public void getCurrentUser() {

        }


    public void clearCart() {
        cart = new Cart();
    }

    public void addTripToCart(Trip trip) {
    }
}
