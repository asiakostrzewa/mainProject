package mainProject.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("/")
    public List<TripDTO> getAllTrips(){
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public TripDTO getTripInfo(@PathVariable Long id){
        return TripToTripDTOBuilder.buildDTO(tripService.getTripInfo(id));
    }

}
