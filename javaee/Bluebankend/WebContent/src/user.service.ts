import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class UserService {
  constructor (
    private http: Http
  ) {}

  getUser() {
    return this.http.get(`http://127.0.0.1:8080/bluebackend/service//boasvindas`)
    .map((res:Response) => res.json());
  }

}