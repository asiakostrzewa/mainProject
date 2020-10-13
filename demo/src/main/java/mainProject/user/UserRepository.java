package mainProject.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository <T extends User> extends JpaRepository<User,Long> {

    User findByUsername(String loggedUserEmail);
    boolean existsByUsername(String username);
}
