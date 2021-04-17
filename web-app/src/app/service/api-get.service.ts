import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from "../../environments/environment";
import {IJob} from "../ijob";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ApiGetService {
  private apiHost = environment.apiHost + 'get/';

  constructor(private http: HttpClient) {
  }

  getJob(id: number) : Observable<IJob>{
    return this.http.get<IJob>(this.apiHost + 'job/' + id,{responseType: 'json'});
  }
  getAllJobs() : Observable<Array<IJob>>{
    return this.http.get<Array<IJob>>(this.apiHost + 'alljobs',{responseType: 'json'});
  }


}
