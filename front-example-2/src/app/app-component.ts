import { Component, OnInit } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { SearchComponent } from "./components/search/search-component";
import { TableComponent } from "./components/table/table-component";
import { environment } from 'src/environment/environment.development';
import { TaskService } from './service/task-service/task-service';
import { SearchService } from './service/search-service/search-service';
import { Task } from './model/task';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, SearchComponent, TableComponent],
  templateUrl: './app-component.html',
  styleUrls: ['./app-component.scss'],
})
export class AppComponent implements OnInit {

  private taskToDisplay?: Task[];

  constructor(private router: Router, private taskService: TaskService, private searchService: SearchService) {}




  
  ngOnInit(): void {
    if(environment.useMockData) {
      this.DataInsertion.addMockTask();
    }
    this.taskToDisplay = this.taskService.getTasks();
  }

  navigateTo(path: string): void {
    this.router.navigate([path]);
  }

}
