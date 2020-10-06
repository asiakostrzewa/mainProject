package mainProject.trip;

import mainProject.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripRepository<T extends BaseEntity> extends JpaRepository<Trip,Long> {

    Optional<T> findTripById(Long id);
}
