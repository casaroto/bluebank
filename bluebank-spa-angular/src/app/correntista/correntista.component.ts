import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Conta } from '../models';

@Component({
  selector: 'app-correntista',
  templateUrl: './correntista.component.html',
  styleUrls: ['./correntista.component.css']
})
export class CorrentistaComponent implements OnInit {
  contaLogada: Conta = {idCorrentista: 0, nome: '', agencia: 0, conta: 0, contaDac: 0};

  @Input('cpf') cpf = '';
  @Input('urlBase') urlBase = '';
  @Output() correntistaMudou = new EventEmitter<number>();

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.obterContaLogada();
  }

  
  obterContaLogada(): void {
      this.http.get<Conta>(this.urlBase + '/rest/correntista/' + this.cpf)
        .subscribe(
          data => this.tratarObterContaLogada(data),
          err => this.logError(err),
          () => console.log('Sucesso obterContaLogada')
        );
  }

 tratarObterContaLogada(resposta: Conta): void {
    this.contaLogada = resposta;
    console.log(resposta);
     this.correntistaMudou.emit(this.contaLogada.idCorrentista);
 }
	
  logError(err: unknown): void {
	  console.error('Erro: ' + err);
	}

}
