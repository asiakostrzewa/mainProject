package mainProject.trip;

import lombok.Data;

import java.util.List;

@Data
public class TripListResponse {

    List<TripDTO> trips;

    public static TripListResponse from(List<TripDTO> trips){
        return new TripListResponse(trips);
    }

    public TripListResponse(List<TripDTO> trips){
        this.trips = trips;
    }

}
