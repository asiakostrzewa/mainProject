package mainProject.trip;


import java.util.ArrayList;
import javax.persistence.ManyToOne;
import javax.persistence.criteria.*;

import mainProject.MockData;
import mainProject.country.Country;
import mainProject.hotel.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;


@Service
public class NewTripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripToTripDTOBuilder tripToTripDTOBuilder;

//    @Autowired
//    private TripService tripService;


    public void createNewTrip(StartLocation startLocation, PlaceOfDestination placeOfDestination, String leaveDate, String returnDate, Integer howManyDays, TypeOfFoodEnum typeOfFoodEnum, BigDecimal priceForAdult, BigDecimal priceForChild, boolean promoted, Integer placesForAdult, Integer placesForChild) {
        Trip trip = new Trip();
        trip.setStartLocation(startLocation);
        trip.setPlaceOfDestination(placeOfDestination);
        trip.setReturnDate(returnDate);
        trip.setTypeOfFoodEnum(typeOfFoodEnum);
        trip.setPriceForAdult(priceForAdult);
        trip.setPriceForChild(priceForChild);
        trip.setPromoted(promoted);
        trip.setPlacesForAdult(placesForAdult);
        trip.setPlacesForChild(placesForChild);
        tripRepository.save(trip);
    }

    public void updateTrip(TripDTO tripDTO) {
        Trip trip = tripToTripDTOBuilder.buildEntity(tripDTO);
        tripRepository.save(trip);
    }

    @Autowired
    EntityManager em;

    //metoda
    public List<Trip> findTrip() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trip> query = cb.createQuery(Trip.class);
        Root<Trip> root = query.from(Trip.class);
        CriteriaQuery<Trip> id = query.select(root).where(cb.isNotNull(root.get("id")));
        return em.createQuery(id).getResultList();
    }

//    @PostConstruct
//    public void test(){
//        findTrip();
//        System.out.println("udalo sie");


    private void mockProduct(StartLocation startLocation, PlaceOfDestination placeOfDestination, String arriveDate, String returnDate,
                             TypeOfFoodEnum typeOfFoodEnum, BigDecimal priceForAdult, BigDecimal priceForChild) {
        Trip trip = new Trip();
        trip.setStartLocation(startLocation);
        trip.setPlaceOfDestination(placeOfDestination);
        trip.setArriveDate(arriveDate);
        trip.setReturnDate(returnDate);
        trip.setTypeOfFoodEnum(typeOfFoodEnum);
        trip.setPriceForAdult(priceForAdult);
        trip.setPriceForChild(priceForChild);
        tripRepository.save(trip);
    }


    @Autowired
    private NewTripService newTripService;

    StartLocation startLocation = new StartLocation();
    PlaceOfDestination placeOfDestination = new PlaceOfDestination();

    @Autowired
    private MockData mockData;


//    @PostConstruct
//    public void addMockTrips() {
//        List<TripDTO> trip = newTripService.getTrip();
//        startLocation.setAirport();
//        if (tripRepository.findAll().isEmpty()) {
//            mockProduct(startLocation,placeOfDestination, "20.05.2020", "22.05.2020", TypeOfFoodEnum.AI, BigDecimal.valueOf(2000.00), BigDecimal.valueOf(1200.00));
//
//        }
//    }
}




