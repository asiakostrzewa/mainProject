package mainProject.trip;

import java.awt.print.Pageable;
import java.util.ArrayList;
import javax.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

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

    public void updateTrip(TripDTO tripDTO){
        Trip trip = TripToTripDTOBuilder.buildEntity(tripDTO);
        tripRepository.save(trip);
    }

    public List<TripDTO> getAllTrips(){
        return tripRepository.getAllTrips().stream()
                .map(TripToTripDTOBuilder::buildDTO)
                .collect(Collectors.toList());
    }

    public Trip getTripInfo(Long id){
        return tripRepository.getTripInfo(id);
    }

    @Autowired
    EntityManager em;
    //metoda
    public List<Trip> findTrip(StartLocation startLocation, PlaceOfDestination placeOfDestination, String leaveDate, String returnDate, TypeOfFoodEnum typeOfFoodEnum, BigDecimal priceForAdult, BigDecimal priceForChild, Boolean promoted, Integer placesForAdult, Integer placesForChild){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trip> query = cb.createQuery(Trip.class);
        Root<Trip> root = query.from(Trip.class);
        List<Predicate> predicates = new ArrayList<>();
        CriteriaQuery<Trip> id = query.select(root).where(cb.isNotNull(root.get("id")));
        if(startLocation != null){
            predicates.add(cb.equal(root.get("start location"), startLocation));
        }
        if(placeOfDestination != null){
            predicates.add(cb.equal(root.get("place of destination"), placeOfDestination));
        }
        if(!leaveDate.equals("")){
            predicates.add(cb.like(root.get("leave date"), "%" + leaveDate +"%"));
        }
        if(!returnDate.equals("")){
            predicates.add(cb.like(root.get("return date"), "%" + returnDate +"%"));
        }
        if(typeOfFoodEnum != null){
            predicates.add(cb.equal(root.get("type of food"), typeOfFoodEnum));
        }
        if(priceForAdult != null){
            predicates.add(cb.like(root.get("price for adult"), "%" + priceForAdult +"%"));
        }
        if(priceForChild != null){
            predicates.add(cb.like(root.get("price for child"), "%" + priceForChild +"%"));
        }
        if(!promoted.toString().equals("")){
            predicates.add(cb.equal(root.get("promoted"), promoted));
        }
        if(placesForAdult != null){
            predicates.add(cb.equal(root.get("place for adult"), placesForAdult));
        }
        if(placesForChild != null){
            predicates.add(cb.equal(root.get("place for child"), placesForChild));
        }

        query.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(query).getResultList();
    }

}
