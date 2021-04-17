import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ApiPostService {
  private apiHost = environment.apiHost + 'post/';

  constructor(private http: HttpClient) {
  }

  addNewJob(id: number) : void {
    this.http.post(this.apiHost + 'addjob/' + id,null).subscribe(
      response => console.log(response),
      err => console.log(err)
    );
  }
}
