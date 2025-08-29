import { Component, OnInit } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { environment } from 'src/environment/environment.development';
import { TaskService } from './service/task-service/task-service';
import { SearchService } from './service/search-service/search-service';
import { Task } from './model/task';
import { DataInsertion } from 'src/database/datainsertion';
import { TASK_TABLE_HEADERS } from './model/task-table';
import { SearchCriteria } from './model/search';
import { Home } from "./components/home/home";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Home],
  templateUrl: './app-component.html',
  styleUrls: ['./app-component.scss'],
})
export class AppComponent implements OnInit {
  public tableHeaders: (keyof Task)[] = TASK_TABLE_HEADERS;
  public taskToDisplay?: Task[];

  constructor(
    private router: Router,
    private taskService: TaskService,
    private searchService: SearchService
  ) {}

  ngOnInit(): void {
    if (environment.useMockData) {
      const dataInsertion = new DataInsertion(this.taskService);
      dataInsertion.addMockTasks();
    }
    this.taskToDisplay = this.taskService.getTasks();
  }

  handleSearch(searchTerm: string): void {
    const criteria: SearchCriteria = {};
    const trimmedTerm = searchTerm.trim();

    if (trimmedTerm === '') {
      this.taskToDisplay = this.taskService.getTasks();
      return;
    }

    const numId = Number(trimmedTerm);

    if (!isNaN(numId)) {
      criteria.id = numId;
    } else {
      criteria.taskName = trimmedTerm;
    }
    this.taskToDisplay = this.searchService.searchTasks(criteria);
  }

  navigateTo(path: string): void {
    this.router.navigate([path]);
  }
}
