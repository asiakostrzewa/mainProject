import { Component, OnInit, Input } from '@angular/core';

import { OfferService } from '../offer.service';
import { Offer } from '../offer';

@Component({
  selector: 'app-offer-new',
  templateUrl: './offer-new.component.html',
  styleUrls: ['./offer-new.component.css']
})
export class OfferNewComponent implements OnInit {
  @Input() offers: Offer[];

  constructor(private offerService: OfferService) { }

  ngOnInit(): void {
  }

  add(name: string, continent: string, country: string, city: string, hotel: string, hotelStars: string, hotelDescription: string, airport: string, trip: string, startLocation: string, placeOfDestination: string, leaveDate: string, returnDate: string, howManyDays: string, typeOfFoodEnum: string, priceForAdult: string, priceForChild: string, promoted: string, placesForAdult: string, placesForChild: string): void {

    // Usunięcie białych znaków z danych
    name = name.trim();
    continent = continent.trim();
    country = country.trim();
    city = city.trim();
    hotel = hotel.trim();
    hotelStars = hotelStars.trim();
    hotelDescription = hotelDescription.trim();
    airport = airport.trim();
    trip = trip.trim();
    startLocation = startLocation.trim();
    placeOfDestination = placeOfDestination.trim();
    leaveDate = leaveDate.trim();
    returnDate = returnDate.trim();
    howManyDays = howManyDays.trim();
    typeOfFoodEnum = typeOfFoodEnum.trim();
    priceForAdult = priceForAdult.trim();
    priceForChild = priceForChild.trim();
    promoted = promoted.trim();
    placesForAdult = placesForAdult.trim();
    placesForChild = placesForChild.trim();

    // Zaprzestanie wykonywania, kiedy pola są puste
    if (!name || !continent || !country || !city || !hotel || !hotelStars || !hotelDescription || !airport || !trip || !startLocation || !placeOfDestination || !leaveDate || !returnDate || !howManyDays || !typeOfFoodEnum || !priceForAdult || !priceForChild || !promoted || !placesForAdult || !placesForChild) {
      return;
    }

  }

}
