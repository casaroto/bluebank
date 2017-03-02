import { Component } from '@angular/core';
import {Http, Headers, Response, RequestOptions} from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'Bem vindo ao Bluebank!';
  contas;
  urlBase: String;
  contaLogada = {idCorrentista: 0, nome: '', agencia: 0, conta: 0, contaDac: 0};
  res;
  valor = 0;
  correntistaLogado = '58424255135';
  correntistaDestino = 0;
  mensagem: String;

  constructor(private http: Http) {
      this.urlBase = 'http://192.168.0.11:8080/bluebackend';
      this.obterContas();
      this.obterContaLogada();
   }

  obterContaLogada() {
      this.http.get(this.urlBase + '/rest/correntista/' + this.correntistaLogado)
        .map(res => res.json())
        .subscribe(
          data => this.tratarObterContaLogada(data),
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

    if (this.correntistaDestino === 0){
      this.mensagem = "Selecione conta destino!";
      return;
    }

    var dadosTransferencia = this.contaLogada.idCorrentista + '/' + this.correntistaDestino + '/' + this.valor;

    this.http.get(this.urlBase + '/rest/transferencia/' + dadosTransferencia)
        .map(res => res.json())
        .subscribe(
          data => this.tratarTransferir(data),
          err => this.logError(err),
          () => console.log('Sucesso transferir')
        );
	}

 tratarTransferir(resposta){
    console.log(resposta);
    this.mensagem = resposta.mensagem;
 }
  
 tratarObterContaLogada(resposta){
    this.contaLogada = resposta;
    console.log(resposta);
 }
	
  logError(err) {
	  console.error('Erro: ' + err);
	}

}
