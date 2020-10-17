import{NgModule}from'@angular/core';
import {Routes, RouterModule}from '@angular/router';
import {OffersComponent}from './offers/offers.component';
import { OfferEditComponent}from './offer-edit/offer-edit.component';
import {NotFoundComponent}from './not-found/not-found.component';

const routes: Routes = [
{path: '', redirectTo: '/offers', pathMatch: 'full'
},
{path: 'offers', component: OffersComponent},
{path: 'edit/:id', component: OfferEditComponent},
{ path: '**', redirectTo: '/404', pathMatch: 'full'
},
{ path: '404', component: NotFoundComponent}
];

@NgModule({
imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
