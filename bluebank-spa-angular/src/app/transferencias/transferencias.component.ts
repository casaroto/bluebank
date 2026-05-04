import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

@Component({
  selector: 'app-transferencias',
  templateUrl: './transferencias.component.html',
  styleUrls: ['./transferencias.component.css']
})
export class TransferenciasComponent implements OnInit {
  urlBase = 'http://localhost:8080';
  correntistaLogado = '58424255135';
  contas;
  valor = 0;
  idCorrentistaLogado = 0;
  correntistaDestino = 0;
  mensagem = '';

  constructor(private http: Http) { }

  ngOnInit() {
    this.obterContaLogada();
    this.obterContas();
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
    this.http.get(this.urlBase + '/rest/correntistas/cadastrados/transferencia/' + this.correntistaLogado)
      .map(res => res.json())
      .subscribe(
        data => this.contas = data,
        err => this.logError(err),
        () => console.log('Sucesso obterContas')
      );
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

}
