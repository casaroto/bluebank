import { Component, Directive } from '@angular/core';
import {Http, Headers, Response, RequestOptions} from '@angular/http';

import {CorrentistaComponent} from './correntista/correntista.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'Bem vindo ao Bluebank!';
  contas;
  urlBase: String;

  res;
  valor = 0;
  correntistaLogado = '58424255135';
  idCorrentistaLogado = 0;
  correntistaDestino = 0;
  mensagem: String;

  constructor(private http: Http) {
      //this.urlBase = 'http://ec2-52-206-208-89.compute-1.amazonaws.com/bluebackend';
      this.urlBase = 'http://ec2-52-87-229-207.compute-1.amazonaws.com/bluebackend';

      this.obterContas();
    //  this.obterContaLogada();
   }
/*
  obterContaLogada() {
      this.http.get(this.urlBase + '/rest/correntista/' + this.correntistaLogado)
        .map(res => res.json())
        .subscribe(
          data => this.tratarObterContaLogada(data),
          err => this.logError(err),
          () => console.log('Sucesso obterContaLogada')
        );
  }*/

  onCorrentistaMudou(id: number){
    console.log('idCorrentista' + id);
    this.idCorrentistaLogado = id;
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

   var dadosTransferencia = this.idCorrentistaLogado + '/' + this.correntistaDestino + '/' + this.valor;

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
  
  /*
 tratarObterContaLogada(resposta){
    this.contaLogada = resposta;
    console.log(resposta);
 }*/
	
  logError(err) {
	  console.error('Erro: ' + err);
	}

}
