import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ApiPostService {
  private apiHost = environment.apiHost + 'post/';

  constructor(private http: HttpClient) {
  }

  addNewJob(id: number): Observable<Object> {
    return this.http.post(this.apiHost + 'addjob/' + id,null)
  }
}
