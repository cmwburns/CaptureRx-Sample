import {Component} from '@angular/core';
import {IJob} from "./ijob";
import {ApiGetService} from "./service/api-get.service";
import {ApiPostService} from "./service/api-post.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'CaptureRx Sample Project';
  postJobId: number;
  getJobId: number;
  job: IJob;
  jobList: Array<IJob>;
  invalidRequest: boolean;
  constructor(private apiGetService: ApiGetService, private apiPostService: ApiPostService) {
  }

  setPostJobId(event) {
    this.postJobId = event.target.value;
  }

  setGetJobId(event) {
    this.getJobId = event.target.value;
  }

  addJob() {
    this.apiPostService.addNewJob(this.postJobId).subscribe(
      response => {
        console.log(response);
        this.invalidRequest = false;
      },
      err => {
        console.log(err);
        this.invalidRequest = true;
      }
    );
  }

  getJob() {
    this.apiGetService.getJob(this.getJobId).subscribe(job => this.job = job);
  }

  getAllJobs() {
    this.apiGetService.getAllJobs().subscribe(jobList => this.jobList = jobList);
  }

}
