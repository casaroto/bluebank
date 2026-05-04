import { Component } from '@angular/core';
import { Http } from '@angular/http';
import { DemoUser, UserSessionService } from './user-session.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'Bluebank';
  urlBase = 'http://localhost:8080';
  users: DemoUser[];
  selectedCpf: string;
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

  constructor(private userSession: UserSessionService, private http: Http) {
    this.users = userSession.users;
    this.selectedCpf = userSession.currentUser.cpf;
    this.obterContaLogada();
  }

  trocarUsuario() {
    this.userSession.selectUser(this.selectedCpf);
    this.obterContaLogada();
  }

  obterContaLogada() {
    this.http.get(this.urlBase + '/rest/correntista/' + this.selectedCpf)
      .map(res => res.json())
      .subscribe(
        data => this.contaLogada = data,
        err => this.logError(err),
        () => console.log('Sucesso obterContaLogada')
      );
  }

  logError(err) {
    console.error('Erro: ' + err);
  }
}
