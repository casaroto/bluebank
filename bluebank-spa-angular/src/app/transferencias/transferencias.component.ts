import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Subscription } from 'rxjs';

import { Conta, TransferenciaResponse } from '../models';
import { UserSessionService } from '../user-session.service';

@Component({
  selector: 'app-transferencias',
  imports: [CommonModule, FormsModule],
  templateUrl: './transferencias.component.html',
  styleUrls: ['./transferencias.component.css']
})
export class TransferenciasComponent implements OnInit, OnDestroy {
  urlBase = '/bluebackend';
  correntistaLogado = '';
  userSubscription?: Subscription;
  contas: Conta[] = [];
  valor = 0;
  idCorrentistaLogado = 0;
  correntistaDestino = 0;
  mensagem = '';
  carregandoContas = false;
  mensagemContas = '';

  constructor(private http: HttpClient, private userSession: UserSessionService) { }

  ngOnInit(): void {
    this.userSubscription = this.userSession.userChanges.subscribe(user => {
      this.correntistaLogado = user.cpf;
      this.correntistaDestino = 0;
      this.mensagem = '';
      this.mensagemContas = '';
      this.obterContaLogada();
      this.obterContas();
    });
  }

  ngOnDestroy(): void {
    if (this.userSubscription) {
      this.userSubscription.unsubscribe();
    }
  }

  obterContaLogada(): void {
    this.http.get<Conta>(this.urlBase + '/rest/correntista/' + this.correntistaLogado)
      .subscribe(
        data => this.idCorrentistaLogado = data.idCorrentista,
        err => this.logError(err),
        () => console.log('Sucesso obterContaLogada')
      );
  }

  obterContas(): void {
    this.carregandoContas = true;
    this.contas = [];
    this.mensagemContas = 'Carregando contas autorizadas...';

    this.http.get<Conta[]>(this.urlBase + '/rest/correntistas/cadastrados/transferencia/' + this.correntistaLogado)
      .subscribe(
        data => this.tratarObterContas(data),
        err => this.logErrorContas(err),
        () => console.log('Sucesso obterContas')
      );
  }

  tratarObterContas(resposta: Conta[]): void {
    this.contas = resposta || [];
    this.carregandoContas = false;
    this.mensagemContas = this.contas.length ? '' : 'Nenhuma conta autorizada para este correntista.';
  }

  transferir(): void {
    if (!this.correntistaDestino) {
      this.mensagem = 'Selecione conta destino!';
      return;
    }

    if (!this.valor || this.valor <= 0) {
      this.mensagem = 'Informe o valor da transferência!';
      return;
    }

    const dadosTransferencia = this.idCorrentistaLogado + '/' + this.correntistaDestino + '/' + this.valor;

    this.http.get<TransferenciaResponse>(this.urlBase + '/rest/transferencia/' + dadosTransferencia)
      .subscribe(
        data => this.tratarTransferir(data),
        err => this.logError(err),
        () => console.log('Sucesso transferir')
      );
  }

  tratarTransferir(resposta: TransferenciaResponse): void {
    this.mensagem = resposta.mensagem;
    this.obterContas();
  }

  logError(err: unknown): void {
    this.mensagem = 'Não foi possível concluir a operação.';
    console.error('Erro: ' + err);
  }

  logErrorContas(err: unknown): void {
    this.carregandoContas = false;
    this.mensagemContas = 'Não foi possível carregar as contas para transferência.';
    console.error('Erro: ' + err);
  }

}
