import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

export interface DemoUser {
  name: string;
  cpf: string;
}

@Injectable({
  providedIn: 'root'
})
export class UserSessionService {
  private selectedUser = new BehaviorSubject<DemoUser>({
    name: 'Ana Maria',
    cpf: '58424255135'
  });

  users: DemoUser[] = [
    { name: 'Ana Maria', cpf: '58424255135' },
    { name: 'Maria Luiza', cpf: '38521876300' },
    { name: 'Orlando Silva', cpf: '33165275670' },
    { name: 'Osvaldo Augusto', cpf: '44044173656' },
    { name: 'Tatiana Cristina', cpf: '12864164264' }
  ];

  get userChanges(): Observable<DemoUser> {
    return this.selectedUser.asObservable();
  }

  get currentUser(): DemoUser {
    return this.selectedUser.getValue();
  }

  selectUser(cpf: string): void {
    const selected = this.users.find(user => user.cpf === cpf);

    if (selected) {
      this.selectedUser.next(selected);
    }
  }
}
