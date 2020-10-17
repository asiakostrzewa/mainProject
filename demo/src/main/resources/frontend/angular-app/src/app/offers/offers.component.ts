import { Component, OnInit } from '@angular/core';

import { Offer } from '../offer';
import { OfferService } from '../offer.service';

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {
  offers: Offer[];

  constructor(private offerService: OfferService) { }

  ngOnInit(): void {
    this.getOffers();
  }

  getOffers(): void {
    this.offerService.getOffers()
      .subscribe(offers => this.offers = offers);
  }

  delete(offer: Offer): void {
    this.offers = this.offers.filter(s => s !== offer);
    this.offerService.deleteOffer(offer).subscribe();
  }

  /*add(name: string, email: string): void {
    // Usunięcie białych znaków z danych
    name = name.trim();
    email = email.trim();

    // Zaprzestanie wykonywania, kiedy pola są puste
    if (!name || !email) {
      return;
    }

    // Zaprzestanie wykonywania, kiedy adres e-mail nie zawiera "@"
    if (email.indexOf('@') < 1) {
      return;
    }

    // Przesłanie danych do serwera i zaktualizowanie lokalnej tablicy
    this.offerService.addOffer({ name, email } as Offer)
      .subscribe(offer => {
        this.offers.push(offer);
      });
  }*/
}
