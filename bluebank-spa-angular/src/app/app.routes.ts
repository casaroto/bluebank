import { Routes } from '@angular/router';

import { SaldoComponent } from './saldo/saldo.component';
import { TransferenciasComponent } from './transferencias/transferencias.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: '/saldo',
    pathMatch: 'full'
  },
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
