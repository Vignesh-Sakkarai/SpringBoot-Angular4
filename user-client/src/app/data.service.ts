import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable()
export class DataService {
  constructor(private http:Http) { }
  userarray: User[];

  private extractData(res: Response) {
    let body = res.json();
    return body;
  }

  private handleError (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.status);
  }

  createUser(user){
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let body = JSON.stringify(user);
    return this.http.post('/users/createUser/', body, options ).map((res: Response) => res.json());
  }

  loadUserDetails() {
    return this.http.get('/users/allUsers/').map((res:Response) => res.json());
  }
}
