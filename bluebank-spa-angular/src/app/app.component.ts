import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

import { Conta } from './models';
import { DemoUser, UserSessionService } from './user-session.service';

@Component({
  selector: 'app-root',
  imports: [CommonModule, FormsModule, RouterLink, RouterLinkActive, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'Bluebank';
  urlBase = '/bluebackend';
  users: DemoUser[];
  selectedCpf: string;
  mensagem = '';
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

  constructor(private userSession: UserSessionService, private http: HttpClient) {
    this.users = userSession.users;
    this.selectedCpf = userSession.currentUser.cpf;
    this.obterContaLogada();
  }

  trocarUsuario(): void {
    this.userSession.selectUser(this.selectedCpf);
    this.obterContaLogada();
  }

  obterContaLogada(): void {
    this.mensagem = '';
    this.http.get<Conta>(this.urlBase + '/rest/correntista/' + this.selectedCpf)
      .subscribe(
        data => this.contaLogada = data,
        err => this.logError(err),
        () => console.log('Sucesso obterContaLogada')
      );
  }

  logError(err: unknown): void {
    this.mensagem = 'Não foi possível carregar os dados do correntista.';
    console.error('Erro: ' + err);
  }
}
