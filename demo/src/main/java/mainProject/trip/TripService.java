package mainProject.trip;


import java.util.ArrayList;
import javax.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public void createNewTrip(StartLocation startLocation, PlaceOfDestination placeOfDestination, Date leaveDate, Date returnDate, TypeOfFoodEnum typeOfFoodEnum, BigDecimal priceForAdult, BigDecimal priceForChild, boolean promoted, Integer placesForAdult, Integer placesForChild) {
        Trip trip = new Trip();
        trip.setStartLocation(startLocation);
        trip.setPlaceOfDestination(placeOfDestination);
        trip.setReturnDate(leaveDate);
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
        return tripRepository.findAll().stream()
                .map(TripToTripDTOBuilder::buildDTO)
                .collect(Collectors.toList());
    }

    public Trip getTripInfo(Long id){
        return tripRepository.findTripById(id);
    }

    @Autowired
    EntityManager em;
    public List<Trip> findTrip(QueryParams queryParams){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trip> query = cb.createQuery(Trip.class);
        Root<Trip> root = query.from(Trip.class);
        List<Predicate> predicates = new ArrayList<>();
        CriteriaQuery<Trip> id = query.select(root).where(cb.isNotNull(root.get("id")));
        if(queryParams.getStartLocation() != null){
            predicates.add(cb.equal(root.get("start location"), queryParams.getStartLocation()));
        }
        try{
            if(queryParams.getPlaceOfDestination() != null){
                predicates.add(cb.equal(root.get("place of destination"), queryParams.getPlaceOfDestination()));
            }
        }catch(NullPointerException e){
            System.out.println("Pass a value");
        }
        if(!queryParams.getLeaveDate().equals("")){
            predicates.add(cb.like(root.get("leave date"), "%" + queryParams.getLeaveDate() +"%"));
        }
        if(!queryParams.getReturnDate().equals("")){
            predicates.add(cb.like(root.get("return date"), "%" + queryParams.getReturnDate() +"%"));
        }
        if(queryParams.getTypeOfFoodEnum()!= null){
            predicates.add(cb.equal(root.get("type of food"),queryParams.getTypeOfFoodEnum()));
        }
        if(queryParams.getPriceForAdult()!= null){
            predicates.add(cb.like(root.get("price for adult"), "%" + queryParams.getPriceForAdult() +"%"));
        }
        if(queryParams.getPriceForChild() != null){
            predicates.add(cb.like(root.get("price for child"), "%" + queryParams.getPriceForChild() +"%"));
        }
        if(!queryParams.getPromoted().toString().equals("")){
            predicates.add(cb.equal(root.get("promoted"), queryParams.getPromoted()));
        }
        if(queryParams.getPlacesForAdult() != null){
            predicates.add(cb.equal(root.get("place for adult"), queryParams.getPlacesForAdult()));
        }
        if(queryParams.getPlacesForChild() != null){
            predicates.add(cb.equal(root.get("place for child"), queryParams.getPlacesForChild()));
        }

        query.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(query).getResultList();
    }

}
