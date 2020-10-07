package mainProject.trip;

import mainProject.airport.AirportRepository;
import mainProject.city.CityRepository;
import mainProject.continent.ContinentRepository;
import mainProject.country.CountryRepository;
import mainProject.hotel.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripToTripDTOBuilder {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private TripRepository tripRepository;

    public TripDTO buildDTO(Trip trip){
        return TripDTO.builder()
                .id(trip.getId())
                .startLocation(trip.getStartLocation())
                .placeOfDestination(trip.getPlaceOfDestination())
                .leaveDate(trip.getLeaveDate())
                .returnDate(trip.getReturnDate())
                .typeOfFoodEnum(trip.getTypeOfFoodEnum())
                .priceForAdult(trip.getPriceForAdult())
                .priceForChild(trip.getPriceForChild())
                .promoted(trip.isPromoted())
                .placesForAdult(trip.getPlacesForAdult())
                .placesForChild(trip.getPlacesForChild())
                .build();
    }

    public Trip buildEntity(TripDTO tripDTO){
        Trip trip = null;

        trip.setStartLocation(tripDTO.getStartLocation());
        trip.setPlaceOfDestination(tripDTO.getPlaceOfDestination());
        trip.setLeaveDate(tripDTO.getLeaveDate());
        trip.setReturnDate(tripDTO.getReturnDate());
        //trip.setHowManyDays(tripDTO.getHowManyDays());
        trip.setTypeOfFoodEnum(tripDTO.getTypeOfFoodEnum());
        trip.setPriceForAdult(tripDTO.getPriceForAdult());
        trip.setPriceForChild(tripDTO.getPriceForChild());
        trip.setPromoted(tripDTO.isPromoted());
        trip.setPlacesForAdult(tripDTO.getPlacesForAdult());
        trip.setPlacesForChild(tripDTO.getPlacesForChild());
        return trip;
    }


}
