package mainProject;

import com.google.gson.Gson;
import lombok.Getter;
import mainProject.cart.Cart;
import mainProject.trip.Trip;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


@Service
@SessionScope
public class UserContextService {


    @Getter
    private Cart cart = new Cart();
    private static Gson gson = new Gson();

    public String getCartAsJson() {
        return gson.toJson(cart);
    }

    public void addTripToCart(Trip trip) {
    }
}
