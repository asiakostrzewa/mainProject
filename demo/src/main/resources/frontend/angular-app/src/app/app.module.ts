import{BrowserModule}from'@angular/platform-browser';
import {NgModule }from '@angular/core';
import {FormsModule}from '@angular/forms';
import {HttpClientModule}from '@angular/common/http';

import {AppRoutingModule}from './app-routing.module';
import {AppComponent}from './app.component';
import {OffersComponent }from './offers/offers.component';
import {OfferEditComponent}from './offer-edit/offer-edit.component';
import {NotFoundComponent}from './not-found/not-found.component';
import {OfferNewComponent}from './offer-new/offer-new.component';

@NgModule({
declarations: [
AppComponent,
OffersComponent,
OfferEditComponent,
NotFoundComponent,
OfferNewComponent
],
imports: [
BrowserModule,
AppRoutingModule,
HttpClientModule,
FormsModule
],
providers: [],
bootstrap: [AppComponent]
})
export class AppModule {

}
