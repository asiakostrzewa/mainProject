package mainProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootWithAngularApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithAngularApplication.class,args);
    }

}
