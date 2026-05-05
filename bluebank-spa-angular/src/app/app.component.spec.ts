import { TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http';
import { HttpTestingController, provideHttpClientTesting } from '@angular/common/http/testing';
import { provideRouter } from '@angular/router';

import { AppComponent } from './app.component';

describe('AppComponent', () => {
  let httpMock: HttpTestingController;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppComponent],
      providers: [
        provideHttpClient(),
        provideHttpClientTesting(),
        provideRouter([])
      ]
    }).compileComponents();

    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('renders the Bluebank shell', () => {
    const fixture = TestBed.createComponent(AppComponent);

    httpMock.expectOne('/bluebackend/rest/correntista/58424255135').flush({
      idCorrentista: 1,
      nome: 'Ana Maria',
      cpf: '58424255135',
      banco: 341,
      agencia: 1234,
      agenciaDac: 5,
      conta: 98765,
      contaDac: 0,
      saldo: 1500
    });
    fixture.detectChanges();

    const compiled = fixture.nativeElement as HTMLElement;

    expect(compiled.querySelector('h1')?.textContent).toContain('Bluebank');
    expect(compiled.textContent).toContain('Ana Maria');
    expect(compiled.textContent).toContain('R$ 1500');
  });
});
