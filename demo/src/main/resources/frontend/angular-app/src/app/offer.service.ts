import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Offer } from './offer';

@Injectable({
providedIn: 'root'
})
export class OfferService {

private offersUrl = 'https://jsonplaceholder.typicode.com/users';

httpOptions = {
headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getOffers(): Observable<Offer[]> {
    return this.http.get<Offer[]>(this.offersUrl);
  }

  getOffer(id: number): Observable<Offer> {
    const url = `${this.offersUrl}/${id}`;
    return this.http.get<Offer>(url);
  }

  updateOffer(offer: Offer): Observable<Offer> {
    const url = `${this.offersUrl}/${offer.id}`;
    return this.http.put<Offer>(url, offer, this.httpOptions);
  }

  addOffer(offer: Offer): Observable<Offer> {
    return this.http.post<Offer>(this.offersUrl, offer, this.httpOptions);
  }

  deleteOffer(offer: Offer): Observable<Offer> {
    const url = `${this.offersUrl}/${offer.id}`;
    return this.http.delete<Offer>(url, this.httpOptions);
  }
}
