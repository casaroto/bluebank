import { Component, OnDestroy, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subscription } from 'rxjs';

import { Conta } from '../models';
import { UserSessionService } from '../user-session.service';

@Component({
  selector: 'app-saldo',
  templateUrl: './saldo.component.html',
  styleUrls: ['./saldo.component.css']
})
export class SaldoComponent implements OnInit, OnDestroy {
  urlBase = '/bluebackend';
  correntistaLogado = '';
  userSubscription?: Subscription;
  contaLogada: Conta = {
    idCorrentista: 0,
    nome: '',
    cpf: '',
    banco: 0,
    agencia: 0,
    agenciaDac: 0,
    conta: 0,
    contaDac: 0,
    saldo: 0
  };
  mensagem = '';

  constructor(private http: HttpClient, private userSession: UserSessionService) { }

  ngOnInit(): void {
    this.userSubscription = this.userSession.userChanges.subscribe(user => {
      this.correntistaLogado = user.cpf;
      this.obterSaldo();
    });
  }

  ngOnDestroy(): void {
    if (this.userSubscription) {
      this.userSubscription.unsubscribe();
    }
  }

  obterSaldo(): void {
    this.http.get<Conta>(this.urlBase + '/rest/correntista/' + this.correntistaLogado)
      .subscribe(
        data => this.contaLogada = data,
        err => this.logError(err),
        () => console.log('Sucesso obterSaldo')
      );
  }

  logError(err: unknown): void {
    this.mensagem = 'Não foi possível consultar o saldo.';
    console.error('Erro: ' + err);
  }

}
