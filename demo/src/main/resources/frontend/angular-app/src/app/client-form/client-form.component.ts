import { Component, OnInit, Input } from '@angular/core';

import { OfferService } from '../offer.service';
import { Offer } from '../offer';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent implements OnInit {
  @Input() offers: Offer[];

  constructor(private offerService: OfferService) { }

  ngOnInit(): void {
  }

  add(name: string, email: string): void {

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
  }

}

