package mainProject.cart;

import mainProject.UserContextService;
import mainProject.trip.Trip;
import mainProject.trip.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
    @Autowired
    private TripRepository<Trip> tripRepository;

    @Autowired
    private UserContextService userContextService;



    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestParam(required = false) String prodId) {

        tripRepository.findTripById(Long.valueOf(prodId)).ifPresent(userContextService::addTripToCart);
        return ResponseEntity.ok().body(userContextService.getCartAsJson());
    }

    @GetMapping(value = "/cartElements")
    public ResponseEntity<String> cartElements() {
        String cartAsJson = userContextService.getCartAsJson();
        if (cartAsJson == null) {
            return ResponseEntity.badRequest().body("Brak wycieczek o podanych parametrach");
        }
        return ResponseEntity.ok().body(cartAsJson);
    }
}
