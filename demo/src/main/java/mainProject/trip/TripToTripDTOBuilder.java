package mainProject.trip;

public class TripToTripDTOBuilder {

    public static TripDTO buildDTO(Trip trip){
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

    public static Trip buildEntity(TripDTO tripDTO){
        Trip trip = null;

        trip.setStartLocation(tripDTO.getStartLocation());
        trip.setPlaceOfDestination(tripDTO.getPlaceOfDestination());
        trip.setLeaveDate(tripDTO.getLeaveDate());
        trip.setReturnDate(tripDTO.getReturnDate());
        trip.setTypeOfFoodEnum(tripDTO.getTypeOfFoodEnum());
        trip.setPriceForAdult(tripDTO.getPriceForAdult());
        trip.setPriceForChild(tripDTO.getPriceForChild());
        trip.setPromoted(tripDTO.getPromoted());
        trip.setPlacesForAdult(tripDTO.getPlacesForAdult());
        trip.setPlacesForChild(tripDTO.getPlacesForChild());
        return trip;
    }


}
