/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { CorrentistaComponent } from './correntista.component';

describe('CorrentistaComponent', () => {
  let component: CorrentistaComponent;
  let fixture: ComponentFixture<CorrentistaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CorrentistaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CorrentistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
