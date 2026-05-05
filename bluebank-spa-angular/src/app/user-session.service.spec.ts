import { TestBed } from '@angular/core/testing';

import { UserSessionService } from './user-session.service';

describe('UserSessionService', () => {
  it('publishes the selected user', () => {
    const service = TestBed.inject(UserSessionService);
    const observedCpfs: string[] = [];

    const subscription = service.userChanges.subscribe(user => observedCpfs.push(user.cpf));
    service.selectUser('38521876300');
    subscription.unsubscribe();

    expect(service.currentUser.name).toBe('Maria Luiza');
    expect(observedCpfs).toEqual(['58424255135', '38521876300']);
  });
});
