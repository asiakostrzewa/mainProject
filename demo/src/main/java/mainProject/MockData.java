package mainProject;

import com.google.common.collect.Sets;
import mainProject.city.City;
import mainProject.city.CityRepository;
import mainProject.continent.Continent;
import mainProject.continent.ContinentRepository;
import mainProject.country.Country;
import mainProject.country.CountryRepository;
import mainProject.hotel.Hotel;
import mainProject.hotel.HotelRepository;
import mainProject.trip.TripRepository;
import mainProject.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;


@Service
public class MockData {

    @Autowired
    private UserRepository <Customer> usersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private HotelRepository hotelRepository;



//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void mockData() {
//        if (TripRepository.checkSize() == 0) {
//            tripRepository.initializeTrip();
//        }
        if (!usersRepository.existsByUsername("user@user.pl")) {

            Role role = roleRepository.findRoleByRoleName(RoleTypeEnum.USER.getRoleName());
            if (role == null) {
                role = roleRepository.save(new Role(RoleTypeEnum.USER.getRoleName()));
            }
            Customer customer = new Customer();
            usersRepository.save(customer);
            customer.setUsername("user@user.pl");
//            customer.setPassword(passwordEncoder.encode("user12345"));
            customer.setRoles(Sets.newHashSet(role));
            customer.setFirstName("Imię");
            customer.setSurName("Nazwisko");
            usersRepository.save(customer);



            Continent azja = new Continent();
            continentRepository.save(azja);
            azja.setContinentName("Azja");

            Continent afryka = new Continent();
            continentRepository.save(afryka);
            afryka.setContinentName("Afryka");

            Continent europa = new Continent();
            continentRepository.save(europa);
            europa.setContinentName("Europa");

            Continent amerykaPoludniowa = new Continent();
            continentRepository.save(amerykaPoludniowa);
            amerykaPoludniowa.setContinentName("Ameryka Południowa");

            Continent amerykaPólnocna = new Continent();
            continentRepository.save(amerykaPólnocna);
            amerykaPólnocna.setContinentName("Ameryka Północna");

            Continent australia = new Continent();
            continentRepository.save(australia);
            australia.setContinentName("Australia");


            Country chiny = new Country();
            chiny.setCountryName("Chiny");
            chiny.setContinent(azja);
            countryRepository.save(chiny);

            Country japonia= new Country();
            japonia.setCountryName("Japonia");
            japonia.setContinent(azja);
            countryRepository.save(japonia);

            Country egipt = new Country();
            egipt.setCountryName("Egipt");
            egipt.setContinent(afryka);
            countryRepository.save(egipt);

            Country tunezja = new Country();
            tunezja.setCountryName("Tunezja");
            tunezja.setContinent(afryka);
            countryRepository.save(tunezja);

            Country hiszpania = new Country();
            hiszpania.setCountryName("Hiszpania");
            hiszpania.setContinent(europa);
            countryRepository.save(hiszpania);

            Country włochy = new Country();
            włochy.setCountryName("Włochy");
            włochy.setContinent(afryka);
            countryRepository.save(włochy);

            Country argentyna = new Country();
            argentyna.setCountryName("Argentyna");
            argentyna.setContinent(amerykaPoludniowa);
            countryRepository.save(argentyna);

            Country brazylia= new Country();
            brazylia.setCountryName("Brazylia");
            brazylia.setContinent(amerykaPoludniowa);
            countryRepository.save(brazylia);

            Country kanada = new Country();
            kanada.setCountryName("Kanada");
            kanada.setContinent(amerykaPólnocna);
            countryRepository.save(kanada);

            Country usa = new Country();
            usa.setCountryName("USA");
            usa.setContinent(amerykaPólnocna);
            countryRepository.save(usa);

            Country nowaZelandia = new Country();
            nowaZelandia.setCountryName("Nowa Zelandia");
            nowaZelandia.setContinent(australia);
            countryRepository.save(nowaZelandia);

            Country nowaGwinea = new Country();
            nowaGwinea.setCountryName("Nowa Gwinea");
            nowaGwinea.setContinent(australia);
            countryRepository.save(nowaGwinea);

            City pekin = new City();
            pekin.setCityName("Pekin");
            pekin.setCountry(chiny);
            cityRepository.save(pekin);

            City szanghaj = new City();
            szanghaj.setCityName("Szanghaj");
            szanghaj.setCountry(chiny);
            cityRepository.save(szanghaj);

            City tokio = new City();
            tokio.setCityName("Tokio");
            tokio.setCountry(japonia);
            cityRepository.save(tokio);

            City sharmElSheikh = new City();
            sharmElSheikh.setCityName("Sharm El Sheikh");
            sharmElSheikh.setCountry(egipt);
            cityRepository.save(sharmElSheikh);

            City hurghada = new City();
            hurghada.setCityName("Hurghada");
            hurghada.setCountry(egipt);
            cityRepository.save(hurghada);

            City djerba = new City();
            djerba.setCityName("Djerba");
            djerba.setCountry(tunezja);
            cityRepository.save(djerba);

            City tunis = new City();
            tunis.setCityName("Tunis");
            tunis.setCountry(tunezja);
            cityRepository.save(tunis);

            City madryt = new City();
            madryt.setCityName("Madryt");
            madryt.setCountry(hiszpania);
            cityRepository.save(madryt);

            City majorka = new City();
            majorka.setCityName("Majorka");
            majorka.setCountry(hiszpania);
            cityRepository.save(majorka);

            City rzym = new City();
            rzym.setCityName("Rzym");
            rzym.setCountry(włochy);
            cityRepository.save(rzym);

            City toskania = new City();
            toskania.setCityName("Toskania");
            toskania.setCountry(włochy);
            cityRepository.save(toskania);

            City buenosAires = new City();
            buenosAires.setCityName("Buenos Aires");
            buenosAires.setCountry(argentyna);
            cityRepository.save(buenosAires);

            City rioDeJaneiro = new City();
            rioDeJaneiro.setCityName("Rio de Janeiro");
            rioDeJaneiro.setCountry(brazylia);
            cityRepository.save(rioDeJaneiro);

            City vancouver = new City();
            vancouver.setCityName("Vancouver");
            vancouver.setCountry(kanada);
            cityRepository.save(vancouver);

            City toronto = new City();
            toronto.setCityName("Toronto");
            toronto.setCountry(kanada);
            cityRepository.save(toronto);

            City nowyJork = new City();
            nowyJork.setCityName("Nowy Jork");
            nowyJork.setCountry(usa);
            cityRepository.save(nowyJork);

            City losAngeles = new City();
            losAngeles.setCityName("Los Angeles");
            losAngeles.setCountry(usa);
            cityRepository.save(losAngeles);

            City wellington = new City();
            wellington.setCityName("Wellington");
            wellington.setCountry(nowaZelandia);
            cityRepository.save(wellington);

            City portMoresby = new City();
            portMoresby.setCityName("Port Moresby");
            portMoresby.setCountry(nowaGwinea);
            cityRepository.save(portMoresby);

            Hotel puxuanHotel = new Hotel();
            puxuanHotel.setHotelName("Puxuan Hotel");
            puxuanHotel.setHotelStars(4.0);
            puxuanHotel.setHotelDescription("Niedaleko stacji metra");
            puxuanHotel.setCity(pekin);

            Hotel urbanRosa = new Hotel();
            urbanRosa.setHotelName("Urban Rosa");
            urbanRosa.setHotelStars(3.5);
            urbanRosa.setHotelDescription("Blisko centum");
            urbanRosa.setCity(szanghaj);

            Hotel shinagawaPrince = new Hotel();
            shinagawaPrince.setHotelName("Shinagawa Prince");
            shinagawaPrince.setHotelStars(4.5);
            shinagawaPrince.setHotelDescription("W samym centrum miasta!!");
            shinagawaPrince.setCity(tokio);

            Hotel marinaSharm = new Hotel();
            marinaSharm.setHotelName("Marina Sharm");
            marinaSharm.setHotelStars(4.0);
            marinaSharm.setHotelDescription("Bezposrednio przy plaży");
            marinaSharm.setCity(sharmElSheikh);

            Hotel coralBeach = new Hotel();
            coralBeach.setHotelName("Coral Beach");
            coralBeach.setHotelStars(4.5);
            coralBeach.setHotelDescription("Dwa baseny na terenie hotelu");
            coralBeach.setCity(hurghada);

            Hotel thalasso = new Hotel();
            thalasso.setHotelName("Thalasso");
            thalasso.setHotelStars(5.0);
            thalasso.setHotelDescription("Nowy hotel z 2019 roku");
            thalasso.setCity(djerba);

            Hotel carlton = new Hotel();
            carlton.setHotelName("Carlton");
            carlton.setHotelStars(4.5);
            carlton.setHotelDescription("Hotel położony w samym sercu Tunis");
            carlton.setCity(tunis);

            Hotel pestanaPlaza = new Hotel();
            pestanaPlaza.setHotelName("Pestana Plaza");
            pestanaPlaza.setHotelStars(3.0);
            pestanaPlaza.setHotelDescription("2km do centrum Madrytu");
            pestanaPlaza.setCity(madryt);

            Hotel abracadabra = new Hotel();
            abracadabra.setHotelName("Abracadabra");
            abracadabra.setHotelStars(4.5);
            abracadabra.setHotelDescription("Piekny, nowoczesny hotel, strefa SPA");
            abracadabra.setCity(madryt);

            Hotel mallorcaHotel = new Hotel();
            mallorcaHotel.setHotelName("Mallorca Hotel");
            mallorcaHotel.setHotelStars(4.0);
            mallorcaHotel.setHotelDescription("Hotel usytuowany przy piaszczystej plaży");
            mallorcaHotel.setCity(majorka);

            Hotel paolo = new Hotel();
            paolo.setHotelName("Paolo");
            paolo.setHotelStars(4.5);
            paolo.setHotelDescription("Piękny hotel w centum Rzymu");
            paolo.setCity(rzym);

            Hotel sunshine = new Hotel();
            sunshine.setHotelName("Sunshine");
            sunshine.setHotelStars(3.5);
            sunshine.setHotelDescription("Mały, rodzinny hotel. Wyśmienite jedzenie");
            sunshine.setCity(rzym);

            Hotel hortoConvento = new Hotel();
            hortoConvento.setHotelName("Horto Convento");
            hortoConvento.setHotelStars(4.0);
            hortoConvento.setHotelDescription("Hotel usytuowany w pięknej okolicy");
            hortoConvento.setCity(toskania);

            Hotel maderoHotel = new Hotel();
            maderoHotel.setHotelName("Madero Hotel");
            maderoHotel.setHotelStars(3.0);
            maderoHotel.setHotelDescription("Mały, przytulny hotel");
            maderoHotel.setCity(buenosAires);

            Hotel emilianoRio = new Hotel();
            emilianoRio.setHotelName("Emiliano Rio");
            emilianoRio.setHotelStars(4.5);
            emilianoRio.setHotelDescription("Hotel położony naprzeciwko plaży Copacabana");
            emilianoRio.setCity(rioDeJaneiro);

            Hotel fairmontHotel = new Hotel();
            fairmontHotel.setHotelName("Fairmont Hotel");
            fairmontHotel.setHotelStars(5.0);
            fairmontHotel.setHotelDescription("Ekskluzywny hotel w centum Vancouver");
            fairmontHotel.setCity(vancouver);

            Hotel rocneyHotel = new Hotel();
            rocneyHotel.setHotelName("Rocney Hotel");
            rocneyHotel.setHotelStars(3.0);
            rocneyHotel.setHotelDescription("Tętniąca życiem dzielnica mieszkalna z galeriami");
            rocneyHotel.setCity(toronto);

            Hotel cambriaHotel = new Hotel();
            cambriaHotel.setHotelName("Cambria Hotel");
            cambriaHotel.setHotelStars(4.5);
            cambriaHotel.setHotelDescription("Elegancki wystrój, nowoczesne pokoje, wykwintna kuchnia");
            cambriaHotel.setCity(nowyJork);

            Hotel parkCentral = new Hotel();
            parkCentral.setHotelName("Park Central");
            parkCentral.setHotelStars(4.0);
            parkCentral.setHotelDescription("Hotel mieści sie w dzielnicy Manhattan miasta nowy Jork");
            parkCentral.setCity(nowyJork);


            Hotel freehand = new Hotel();
            freehand.setHotelName("Freehand");
            freehand.setHotelStars(4.0);
            freehand.setHotelDescription("Modny hotel mieszczący sie w centrum miasta");
            freehand.setCity(losAngeles);

            Hotel sofitel = new Hotel();
            sofitel.setHotelName("Sofitel");
            sofitel.setHotelStars(4.0);
            sofitel.setHotelDescription("Komfortowy obiekt położony na obrzerzach miasta");
            sofitel.setCity(wellington);

            Hotel hideaway = new Hotel();
            hideaway.setHotelName("Hideaway");
            hideaway.setHotelStars(3.0);
            hideaway.setHotelDescription("Mały hotel, usytuowany w spokojnej okolicy");
            hideaway.setCity(portMoresby);

        }

    }

}
