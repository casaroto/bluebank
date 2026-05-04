import { Component, OnDestroy, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Subscription } from 'rxjs/Subscription';
import { UserSessionService } from '../user-session.service';

@Component({
  selector: 'app-transferencias',
  templateUrl: './transferencias.component.html',
  styleUrls: ['./transferencias.component.css']
})
export class TransferenciasComponent implements OnInit, OnDestroy {
  urlBase = 'http://localhost:8080';
  correntistaLogado = '';
  userSubscription: Subscription;
  contas = [];
  valor = 0;
  idCorrentistaLogado = 0;
  correntistaDestino = 0;
  mensagem = '';
  carregandoContas = false;
  mensagemContas = '';

  constructor(private http: Http, private userSession: UserSessionService) { }

  ngOnInit() {
    this.userSubscription = this.userSession.userChanges.subscribe(user => {
      this.correntistaLogado = user.cpf;
      this.correntistaDestino = 0;
      this.mensagem = '';
      this.mensagemContas = '';
      this.obterContaLogada();
      this.obterContas();
    });
  }

  ngOnDestroy() {
    if (this.userSubscription) {
      this.userSubscription.unsubscribe();
    }
  }

  obterContaLogada() {
    this.http.get(this.urlBase + '/rest/correntista/' + this.correntistaLogado)
      .map(res => res.json())
      .subscribe(
        data => this.idCorrentistaLogado = data.idCorrentista,
        err => this.logError(err),
        () => console.log('Sucesso obterContaLogada')
      );
  }

  obterContas() {
    this.carregandoContas = true;
    this.contas = [];
    this.mensagemContas = 'Carregando contas autorizadas...';

    this.http.get(this.urlBase + '/rest/correntistas/cadastrados/transferencia/' + this.correntistaLogado)
      .map(res => res.json())
      .subscribe(
        data => this.tratarObterContas(data),
        err => this.logErrorContas(err),
        () => console.log('Sucesso obterContas')
      );
  }

  tratarObterContas(resposta) {
    this.contas = resposta || [];
    this.carregandoContas = false;
    this.mensagemContas = this.contas.length ? '' : 'Nenhuma conta autorizada para este correntista.';
  }

  transferir() {
    if (!this.correntistaDestino) {
      this.mensagem = 'Selecione conta destino!';
      return;
    }

    if (!this.valor || this.valor <= 0) {
      this.mensagem = 'Informe o valor da transferência!';
      return;
    }

    var dadosTransferencia = this.idCorrentistaLogado + '/' + this.correntistaDestino + '/' + this.valor;

    this.http.get(this.urlBase + '/rest/transferencia/' + dadosTransferencia)
      .map(res => res.json())
      .subscribe(
        data => this.tratarTransferir(data),
        err => this.logError(err),
        () => console.log('Sucesso transferir')
      );
  }

  tratarTransferir(resposta) {
    this.mensagem = resposta.mensagem;
    this.obterContas();
  }

  logError(err) {
    this.mensagem = 'Não foi possível concluir a operação.';
    console.error('Erro: ' + err);
  }

  logErrorContas(err) {
    this.carregandoContas = false;
    this.mensagemContas = 'Não foi possível carregar as contas para transferência.';
    console.error('Erro: ' + err);
  }

}
