import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {Http, Headers, Response, RequestOptions} from '@angular/http';

@Component({
  selector: 'app-correntista',
  templateUrl: './correntista.component.html',
  styleUrls: ['./correntista.component.css']
})
export class CorrentistaComponent implements OnInit {
  contaLogada = {idCorrentista: 0, nome: '', agencia: 0, conta: 0, contaDac: 0};

  @Input('cpf') cpf: string;
  @Input('urlBase') urlBase: string;
  @Output() onCorrentistaMudou = new EventEmitter<number>();

  constructor(private http: Http) { }

  ngOnInit() {
    this.obterContaLogada();
  }

  
  obterContaLogada() {
      this.http.get(this.urlBase + '/rest/correntista/' + this.cpf)
        .map(res => res.json())
        .subscribe(
          data => this.tratarObterContaLogada(data),
          err => this.logError(err),
          () => console.log('Sucesso obterContaLogada')
        );
  }

 tratarObterContaLogada(resposta){
    this.contaLogada = resposta;
    console.log(resposta);
     this.onCorrentistaMudou.emit(this.contaLogada.idCorrentista);
 }
	
  logError(err) {
	  console.error('Erro: ' + err);
	}

}
