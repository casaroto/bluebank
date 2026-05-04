import { Component, OnDestroy, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Subscription } from 'rxjs/Subscription';
import { UserSessionService } from '../user-session.service';

@Component({
  selector: 'app-saldo',
  templateUrl: './saldo.component.html',
  styleUrls: ['./saldo.component.css']
})
export class SaldoComponent implements OnInit, OnDestroy {
  urlBase = 'http://localhost:8080';
  correntistaLogado = '';
  userSubscription: Subscription;
  contaLogada = {
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

  constructor(private http: Http, private userSession: UserSessionService) { }

  ngOnInit() {
    this.userSubscription = this.userSession.userChanges.subscribe(user => {
      this.correntistaLogado = user.cpf;
      this.obterSaldo();
    });
  }

  ngOnDestroy() {
    if (this.userSubscription) {
      this.userSubscription.unsubscribe();
    }
  }

  obterSaldo() {
    this.http.get(this.urlBase + '/rest/correntista/' + this.correntistaLogado)
      .map(res => res.json())
      .subscribe(
        data => this.contaLogada = data,
        err => this.logError(err),
        () => console.log('Sucesso obterSaldo')
      );
  }

  logError(err) {
    this.mensagem = 'Não foi possível consultar o saldo.';
    console.error('Erro: ' + err);
  }

}
