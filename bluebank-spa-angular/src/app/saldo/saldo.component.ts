import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

@Component({
  selector: 'app-saldo',
  templateUrl: './saldo.component.html',
  styleUrls: ['./saldo.component.css']
})
export class SaldoComponent implements OnInit {
  urlBase = 'http://localhost:8080';
  correntistaLogado = '58424255135';
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

  constructor(private http: Http) { }

  ngOnInit() {
    this.obterSaldo();
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
