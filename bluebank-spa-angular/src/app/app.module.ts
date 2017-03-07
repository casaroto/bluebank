import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { MaterialModule } from '@angular/material';
import { CorrentistaComponent } from './correntista/correntista.component';
import { SaldoComponent } from './saldo/saldo.component';
import { RouterModule, Routes } from '@angular/router';
import { TransferenciasComponent } from './transferencias/transferencias.component';

const appRoutes: Routes = [
  {
    path: 'saldo',
    component: SaldoComponent,
    data: { title: 'Saldo' }
  },
  {
    path: 'transferencias',
    component: TransferenciasComponent,
    data: { title: 'Transferencias' }
  }
];


@NgModule({
  declarations: [
    AppComponent,
    CorrentistaComponent,
    SaldoComponent,
    TransferenciasComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MaterialModule.forRoot(),
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
