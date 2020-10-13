package mainProject.order;


import mainProject.UserContextService;
import mainProject.cart.Cart;
import mainProject.cart.CartService;
import mainProject.trip.TripRepository;
import mainProject.user.Customer;
import mainProject.user.User;
import mainProject.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private UserContextService userContextService;

    @Autowired
    private OrderRepository ordersRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private TripRepository tripRepository;

    public Order placeOrder() {
        Cart cart = userContextService.getCart();
        String loggedUserEmail = userContextService.getLoggedUserEmail();
        User user = userRepository.findByUsername(loggedUserEmail);

        cart.getOrderLines()
                .stream()
                .peek(p -> p.getTrip())
                .map(e->e.getTrip()).forEach(tripRepository::save);


        Order order = ordersRepository.save(new Order(user.getUsername(), cartService.calculateCartPrice(cart), LocalDateTime.now(), cart.getOrderLines(), user, OrderStatus.NEW));
        userContextService.clearCart();
        return order;
    }
}
