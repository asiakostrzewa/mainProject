package mainProject;

import com.google.common.collect.Sets;
import mainProject.airport.Airport;
import mainProject.airport.AirportRepository;
import mainProject.city.City;
import mainProject.city.CityRepository;
import mainProject.continent.Continent;
import mainProject.continent.ContinentRepository;
import mainProject.country.Country;
import mainProject.country.CountryRepository;
import mainProject.hotel.Hotel;
import mainProject.hotel.HotelRepository;
import mainProject.trip.*;
import mainProject.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.math.BigDecimal;


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

    @Autowired
    private AirportRepository airportRepository;



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


            //kontynenty
            Continent azja = new Continent();
            azja.setContinentName("Azja");
            continentRepository.save(azja);

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


            //kraje
            Country polska = new Country();
            polska.setCountryName("Polska");
            polska.setContinent(europa);
            countryRepository.save(polska);

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


            //miasta
            City warszawa = new City();
            warszawa.setCityName("Warszawa");
            warszawa.setCountry(polska);
            cityRepository.save(warszawa);

            City poznan = new City();
            poznan.setCityName("Poznań");
            poznan.setCountry(polska);
            cityRepository.save(poznan);

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



            // lotniska
            Airport chopina = new Airport();
            chopina.setAirportName("Chopina");
            chopina.setCity(warszawa);
            airportRepository.save(chopina);

            Airport ławica = new Airport();
            ławica.setAirportName("Ławica");
            ławica.setCity(poznan);
            airportRepository.save(ławica);

            Airport daxing = new Airport();
            daxing.setAirportName("Daxing");
            daxing.setCity(pekin);
            airportRepository.save(daxing);

            Airport pudong = new Airport();
            pudong.setAirportName("Pudong");
            pudong.setCity(szanghaj);
            airportRepository.save(pudong);

            Airport haneda = new Airport();
            haneda.setAirportName("Haneda");
            haneda.setCity(tokio);
            airportRepository.save(haneda);

            Airport szarmElSzejk = new Airport();
            szarmElSzejk.setAirportName("Szarm El-Szejk");
            szarmElSzejk.setCity(sharmElSheikh);
            airportRepository.save(szarmElSzejk);

            Airport hurgada = new Airport();
            hurgada.setAirportName("Hurgada");
            hurgada.setCity(hurghada);
            airportRepository.save(hurgada);

            Airport dżerbaDżardżis = new Airport();
            dżerbaDżardżis.setAirportName("Dżerba Dżarżis");
            dżerbaDżardżis.setCity(djerba);
            airportRepository.save(dżerbaDżardżis);

            Airport tunisCarthage = new Airport();
            tunisCarthage.setAirportName("Tunis Carthage");
            tunisCarthage.setCity(tunis);
            airportRepository.save(tunisCarthage);

            Airport barajas = new Airport();
            barajas.setAirportName("Barajas");
            barajas.setCity(madryt);
            airportRepository.save(barajas);

            Airport palmaDeMallorca = new Airport();
            palmaDeMallorca.setAirportName("Palma de Mallorca");
            palmaDeMallorca.setCity(majorka);
            airportRepository.save(palmaDeMallorca);

            Airport ciampino = new Airport();
            ciampino.setAirportName("Ciampino");
            ciampino.setCity(rzym);
            airportRepository.save(ciampino);

            Airport galileoGalilei = new Airport();
            galileoGalilei.setAirportName("Galileo Galilei");
            galileoGalilei.setCity(toskania);
            airportRepository.save(galileoGalilei);

            Airport jorgeNewbery = new Airport();
            jorgeNewbery.setAirportName("Jorge Newbery");
            jorgeNewbery.setCity(buenosAires);
            airportRepository.save(jorgeNewbery);

            Airport galeao = new Airport();
            galeao.setAirportName("Galeao");
            galeao.setCity(rioDeJaneiro);
            airportRepository.save(galeao);

            Airport richmond = new Airport();
            richmond.setAirportName("Richmond");
            richmond.setCity(vancouver);
            airportRepository.save(richmond);

            Airport pearson = new Airport();
            pearson.setAirportName("Pearson");
            pearson.setCity(toronto);
            airportRepository.save(pearson);

            Airport laGuardia = new Airport();
            laGuardia.setAirportName("La Guardia");
            laGuardia.setCity(nowyJork);
            airportRepository.save(laGuardia);

            Airport lax = new Airport();
            lax.setAirportName("LAX");
            lax.setCity(losAngeles);
            airportRepository.save(lax);

            Airport auckland = new Airport();
            auckland.setAirportName("Auckland");
            auckland.setCity(wellington);
            airportRepository.save(auckland);

            Airport moresby = new Airport();
            moresby.setAirportName("Moresby");
            moresby.setCity(portMoresby);
            airportRepository.save(moresby);



            //hotele
            Hotel puxuanHotel = new Hotel();
            puxuanHotel.setHotelName("Puxuan Hotel");
            puxuanHotel.setHotelStars(4.0);
            puxuanHotel.setHotelDescription("Niedaleko stacji metra");
            puxuanHotel.setCity(pekin);
            hotelRepository.save(puxuanHotel);


            Hotel urbanRosa = new Hotel();
            urbanRosa.setHotelName("Urban Rosa");
            urbanRosa.setHotelStars(3.5);
            urbanRosa.setHotelDescription("Blisko centum");
            urbanRosa.setCity(szanghaj);
            hotelRepository.save(urbanRosa);

            Hotel shinagawaPrince = new Hotel();
            shinagawaPrince.setHotelName("Shinagawa Prince");
            shinagawaPrince.setHotelStars(4.5);
            shinagawaPrince.setHotelDescription("W samym centrum miasta!!");
            shinagawaPrince.setCity(tokio);
            hotelRepository.save(shinagawaPrince);

            Hotel marinaSharm = new Hotel();
            marinaSharm.setHotelName("Marina Sharm");
            marinaSharm.setHotelStars(4.0);
            marinaSharm.setHotelDescription("Bezposrednio przy plaży");
            marinaSharm.setCity(sharmElSheikh);
            hotelRepository.save(marinaSharm);

            Hotel coralBeach = new Hotel();
            coralBeach.setHotelName("Coral Beach");
            coralBeach.setHotelStars(4.5);
            coralBeach.setHotelDescription("Dwa baseny na terenie hotelu");
            coralBeach.setCity(hurghada);
            hotelRepository.save(coralBeach);

            Hotel thalasso = new Hotel();
            thalasso.setHotelName("Thalasso");
            thalasso.setHotelStars(5.0);
            thalasso.setHotelDescription("Nowy hotel z 2019 roku");
            thalasso.setCity(djerba);
            hotelRepository.save(thalasso);

            Hotel carlton = new Hotel();
            carlton.setHotelName("Carlton");
            carlton.setHotelStars(4.5);
            carlton.setHotelDescription("Hotel położony w samym sercu Tunis");
            carlton.setCity(tunis);
            hotelRepository.save(carlton);

            Hotel pestanaPlaza = new Hotel();
            pestanaPlaza.setHotelName("Pestana Plaza");
            pestanaPlaza.setHotelStars(3.0);
            pestanaPlaza.setHotelDescription("2km do centrum Madrytu");
            pestanaPlaza.setCity(madryt);
            hotelRepository.save(pestanaPlaza);

            Hotel abracadabra = new Hotel();
            abracadabra.setHotelName("Abracadabra");
            abracadabra.setHotelStars(4.5);
            abracadabra.setHotelDescription("Piekny, nowoczesny hotel, strefa SPA");
            abracadabra.setCity(madryt);
            hotelRepository.save(abracadabra);

            Hotel mallorcaHotel = new Hotel();
            mallorcaHotel.setHotelName("Mallorca Hotel");
            mallorcaHotel.setHotelStars(4.0);
            mallorcaHotel.setHotelDescription("Hotel usytuowany przy piaszczystej plaży");
            mallorcaHotel.setCity(majorka);
            hotelRepository.save(mallorcaHotel);

            Hotel paolo = new Hotel();
            paolo.setHotelName("Paolo");
            paolo.setHotelStars(4.5);
            paolo.setHotelDescription("Piękny hotel w centum Rzymu");
            paolo.setCity(rzym);
            hotelRepository.save(paolo);

            Hotel sunshine = new Hotel();
            sunshine.setHotelName("Sunshine");
            sunshine.setHotelStars(3.5);
            sunshine.setHotelDescription("Mały, rodzinny hotel. Wyśmienite jedzenie");
            sunshine.setCity(rzym);
            hotelRepository.save(sunshine);

            Hotel hortoConvento = new Hotel();
            hortoConvento.setHotelName("Horto Convento");
            hortoConvento.setHotelStars(4.0);
            hortoConvento.setHotelDescription("Hotel usytuowany w pięknej okolicy");
            hortoConvento.setCity(toskania);
            hotelRepository.save(hortoConvento);

            Hotel maderoHotel = new Hotel();
            maderoHotel.setHotelName("Madero Hotel");
            maderoHotel.setHotelStars(3.0);
            maderoHotel.setHotelDescription("Mały, przytulny hotel");
            maderoHotel.setCity(buenosAires);
            hotelRepository.save(maderoHotel);

            Hotel emilianoRio = new Hotel();
            emilianoRio.setHotelName("Emiliano Rio");
            emilianoRio.setHotelStars(4.5);
            emilianoRio.setHotelDescription("Hotel położony naprzeciwko plaży Copacabana");
            emilianoRio.setCity(rioDeJaneiro);
            hotelRepository.save(emilianoRio);

            Hotel fairmontHotel = new Hotel();
            fairmontHotel.setHotelName("Fairmont Hotel");
            fairmontHotel.setHotelStars(5.0);
            fairmontHotel.setHotelDescription("Ekskluzywny hotel w centum Vancouver");
            fairmontHotel.setCity(vancouver);
            hotelRepository.save(fairmontHotel);

            Hotel rocneyHotel = new Hotel();
            rocneyHotel.setHotelName("Rocney Hotel");
            rocneyHotel.setHotelStars(3.0);
            rocneyHotel.setHotelDescription("Tętniąca życiem dzielnica mieszkalna z galeriami");
            rocneyHotel.setCity(toronto);
            hotelRepository.save(rocneyHotel);

            Hotel cambriaHotel = new Hotel();
            cambriaHotel.setHotelName("Cambria Hotel");
            cambriaHotel.setHotelStars(4.5);
            cambriaHotel.setHotelDescription("Elegancki wystrój, nowoczesne pokoje, wykwintna kuchnia");
            cambriaHotel.setCity(nowyJork);
            hotelRepository.save(cambriaHotel);

            Hotel parkCentral = new Hotel();
            parkCentral.setHotelName("Park Central");
            parkCentral.setHotelStars(4.0);
            parkCentral.setHotelDescription("Hotel mieści sie w dzielnicy Manhattan miasta nowy Jork");
            parkCentral.setCity(nowyJork);
            hotelRepository.save(parkCentral);


            Hotel freehand = new Hotel();
            freehand.setHotelName("Freehand");
            freehand.setHotelStars(4.0);
            freehand.setHotelDescription("Modny hotel mieszczący sie w centrum miasta");
            freehand.setCity(losAngeles);
            hotelRepository.save(freehand);

            Hotel sofitel = new Hotel();
            sofitel.setHotelName("Sofitel");
            sofitel.setHotelStars(4.0);
            sofitel.setHotelDescription("Komfortowy obiekt położony na obrzerzach miasta");
            sofitel.setCity(wellington);
            hotelRepository.save(sofitel);

            Hotel hideaway = new Hotel();
            hideaway.setHotelName("Hideaway");
            hideaway.setHotelStars(3.0);
            hideaway.setHotelDescription("Mały hotel, usytuowany w spokojnej okolicy");
            hideaway.setCity(portMoresby);
            hotelRepository.save(hideaway);

//            Airport airport = new Airport();
//            City city = new City();
//            Hotel hotel = new Hotel();


            // wycieczka nr 1
            StartLocation location1 = new StartLocation(warszawa,chopina);
            PlaceOfDestination place1 = new PlaceOfDestination(madryt,maderoHotel,barajas);

            Trip firstTrip = new Trip();
            firstTrip.setStartLocation(location1);
            firstTrip.setPlaceOfDestination(place1);
            firstTrip.setArriveDate("22.05.2021");
            firstTrip.setReturnDate("29.05.2021");
            firstTrip.setPriceForChild(BigDecimal.valueOf(1050.00));
            firstTrip.setPriceForAdult(BigDecimal.valueOf(2200.00));
            firstTrip.setTypeOfFoodEnum(TypeOfFoodEnum.AI);
            tripRepository.save(firstTrip);


            // wycieczka nr 2
            StartLocation location2 = new StartLocation(warszawa,chopina);
            PlaceOfDestination place2 = new PlaceOfDestination(nowyJork, cambriaHotel,laGuardia);

            Trip secondTrip = new Trip();
            secondTrip.setStartLocation(location2);
            secondTrip.setPlaceOfDestination(place2);
            secondTrip.setArriveDate("17.07.2021");
            secondTrip.setReturnDate("28.07.2021");
            secondTrip.setPriceForChild(BigDecimal.valueOf(2500.00));
            secondTrip.setPriceForAdult(BigDecimal.valueOf(4200.00));
            secondTrip.setTypeOfFoodEnum(TypeOfFoodEnum.HB);
            tripRepository.save(secondTrip);


            // wycieczka nr 3
            StartLocation location3 = new StartLocation(poznan, ławica);
            PlaceOfDestination place3 = new PlaceOfDestination(hurghada, coralBeach, hurgada);

            Trip thirdTrip = new Trip();
            thirdTrip.setStartLocation(location3);
            thirdTrip.setPlaceOfDestination(place3);
            thirdTrip.setArriveDate("15.09.2021");
            thirdTrip.setReturnDate("22.09.2021");
            thirdTrip.setPriceForChild(BigDecimal.valueOf(1200.00));
            thirdTrip.setPriceForAdult(BigDecimal.valueOf(2200.00));
            thirdTrip.setTypeOfFoodEnum(TypeOfFoodEnum.AI);
            tripRepository.save(thirdTrip);



            // wycieczka nr 4
            StartLocation location4 = new StartLocation(poznan, ławica);
            PlaceOfDestination place4 = new PlaceOfDestination(rzym, sunshine, ciampino);

            Trip fourthTrip = new Trip();
            fourthTrip.setStartLocation(location4);
            fourthTrip.setPlaceOfDestination(place4);
            fourthTrip.setArriveDate("15.04.2021");
            fourthTrip.setReturnDate("22.04.2021");
            fourthTrip.setPriceForChild(BigDecimal.valueOf(1400.00));
            fourthTrip.setPriceForAdult(BigDecimal.valueOf(2400.00));
            fourthTrip.setTypeOfFoodEnum(TypeOfFoodEnum.BB);
            tripRepository.save(fourthTrip);


            // wycieczka nr 5

            StartLocation location5 = new StartLocation(poznan, ławica);
            PlaceOfDestination place5 = new PlaceOfDestination(toskania, hortoConvento, galileoGalilei);

            Trip fifthTrip = new Trip();
            fifthTrip.setStartLocation(location5);
            fifthTrip.setPlaceOfDestination(place5);
            fifthTrip.setArriveDate("01.05.2021");
            fifthTrip.setReturnDate("04.05.2021");
            fifthTrip.setPriceForChild(BigDecimal.valueOf(600.00));
            fifthTrip.setPriceForAdult(BigDecimal.valueOf(1000.00));
            fifthTrip.setTypeOfFoodEnum(TypeOfFoodEnum.FB);
            tripRepository.save(fifthTrip);


            // wycieczka nr 6

            StartLocation location6 = new StartLocation(poznan, ławica);
            PlaceOfDestination place6 = new PlaceOfDestination(tunis,carlton, tunisCarthage);

            Trip sixthTrip = new Trip();
            sixthTrip.setStartLocation(location6);
            sixthTrip.setPlaceOfDestination(place6);
            sixthTrip.setArriveDate("12.08.2021");
            sixthTrip.setReturnDate("19.08.2021");
            sixthTrip.setPriceForChild(BigDecimal.valueOf(1000.00));
            sixthTrip.setPriceForAdult(BigDecimal.valueOf(1950.00));
            sixthTrip.setTypeOfFoodEnum(TypeOfFoodEnum.AI);
            tripRepository.save(sixthTrip);

            // wycieczka nr 7


            StartLocation location7 = new StartLocation(warszawa, chopina);
            PlaceOfDestination place7 = new PlaceOfDestination(szanghaj,urbanRosa, pudong);

            Trip seventhTrip = new Trip();
            seventhTrip.setStartLocation(location7);
            seventhTrip.setPlaceOfDestination(place7);
            seventhTrip.setArriveDate("01.03.2021");
            seventhTrip.setReturnDate("12.03.2021");
            seventhTrip.setPriceForChild(BigDecimal.valueOf(2500.00));
            seventhTrip.setPriceForAdult(BigDecimal.valueOf(5100.00));
            seventhTrip.setTypeOfFoodEnum(TypeOfFoodEnum.FB);
            tripRepository.save(seventhTrip);


            // wycieczka nr 8

            StartLocation location8 = new StartLocation(warszawa, chopina);
            PlaceOfDestination place8 = new PlaceOfDestination(rioDeJaneiro, emilianoRio, galeao);

            Trip eigthTrip = new Trip();
            eigthTrip.setStartLocation(location8);
            eigthTrip.setPlaceOfDestination(place8);
            eigthTrip.setArriveDate("01.10.2021");
            eigthTrip.setReturnDate("10.10.2021");
            eigthTrip.setPriceForChild(BigDecimal.valueOf(3000.00));
            eigthTrip.setPriceForAdult(BigDecimal.valueOf(6000.00));
            eigthTrip.setTypeOfFoodEnum(TypeOfFoodEnum.AI);
            tripRepository.save(eigthTrip);


            // wycieczka nr 9

            StartLocation location9 = new StartLocation(warszawa, chopina);
            PlaceOfDestination place9 = new PlaceOfDestination(tokio, shinagawaPrince, haneda);

            Trip ninthTrip = new Trip();
            ninthTrip.setStartLocation(location9);
            ninthTrip.setPlaceOfDestination(place9);
            ninthTrip.setArriveDate("10.06.2021");
            ninthTrip.setReturnDate("20.06.2021");
            ninthTrip.setPriceForChild(BigDecimal.valueOf(3500.00));
            ninthTrip.setPriceForAdult(BigDecimal.valueOf(6800.00));
            ninthTrip.setTypeOfFoodEnum(TypeOfFoodEnum.BB);
            tripRepository.save(ninthTrip);

            // wycieczka nr 10

            StartLocation location10 = new StartLocation(warszawa, chopina);
            PlaceOfDestination place10 = new PlaceOfDestination(wellington, sofitel, auckland);

            Trip tenthTrip = new Trip();
            tenthTrip.setStartLocation(location10);
            tenthTrip.setPlaceOfDestination(place10);
            tenthTrip.setArriveDate("16.06.2021");
            tenthTrip.setReturnDate("30.06.2021");
            tenthTrip.setPriceForChild(BigDecimal.valueOf(6000.00));
            tenthTrip.setPriceForAdult(BigDecimal.valueOf(10000.00));
            tenthTrip.setTypeOfFoodEnum(TypeOfFoodEnum.FB);
            tripRepository.save(tenthTrip);


        }


       // @PostConstruct
//    public void addMockTrips() {
//        List<TripDTO> trip = newTripService.getTrip();
//        startLocation.setAirport();
//        if (tripRepository.findAll().isEmpty()) {
//            mockProduct(startLocation,placeOfDestination, "20.05.2020", "22.05.2020", TypeOfFoodEnum.AI, BigDecimal.valueOf(2000.00), BigDecimal.valueOf(1200.00));
//
//        }
//    }
    }

}
