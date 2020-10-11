import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Offer } from '../offer';
import { OfferService } from '../offer.service';

@Component({
  selector: 'app-offer-edit',
  templateUrl: './offer-edit.component.html',
  styleUrls: ['./offer-edit.component.css']
})
export class OfferEditComponent implements OnInit {
  offer: Offer;

  constructor(
    private route: ActivatedRoute,
    private offerService: OfferService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getOffer();
  }

  getOffer(): void {
    // Uzyskanie wartości parametru "id" i jego konwersja na liczbę
    const id = +this.route.snapshot.paramMap.get('id');
    this.offerService.getOffer(id)
      .subscribe(offer => this.offer = offer);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.offerService.updateOffer(this.offer)
      .subscribe(() => this.goBack());
  }
}
