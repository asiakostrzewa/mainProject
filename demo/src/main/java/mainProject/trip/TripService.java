package mainProject.trip;

import javax.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripToTripDTOBuilder tripToTripDTOBuilder;


    public void createNewTrip(StartLocation startLocation, PlaceOfDestination placeOfDestination, String leaveDate, String returnDate, Integer howManyDays, TypeOfFoodEnum typeOfFoodEnum, BigDecimal priceForAdult, BigDecimal priceForChild, boolean promoted, Integer placesForAdult, Integer placesForChild) {
        Trip trip = new Trip();
        trip.setStartLocation(startLocation);
        trip.setPlaceOfDestination(placeOfDestination);
        trip.setReturnDate(returnDate);
        //trip.setHowManyDays(howManyDays);
        trip.setTypeOfFoodEnum(typeOfFoodEnum);
        trip.setPriceForAdult(priceForAdult);
        trip.setPriceForChild(priceForChild);
        trip.setPromoted(promoted);
        trip.setPlacesForAdult(placesForAdult);
        trip.setPlacesForChild(placesForChild);
        tripRepository.save(trip);
    }

    public void updateTrip(TripDTO tripDTO){
        Trip trip = tripToTripDTOBuilder.buildEntity(tripDTO);
        tripRepository.save(trip);
    }

    @Autowired
    EntityManager em;
    //metoda
    public List<Trip> findTrip(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trip> query = cb.createQuery(Trip.class);
        Root<Trip> root = query.from(Trip.class);
        CriteriaQuery<Trip> id = query.select(root).where(cb.isNotNull(root.get("id")));
        return em.createQuery(id).getResultList();
    }

    @PostConstruct
    public void test(){
        findTrip();
        System.out.println("udalo sie");
    }


}
