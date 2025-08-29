import { Component, OnInit } from '@angular/core';
import { TableComponent } from '../table/table-component';
import { SearchComponent } from '../search/search-component';
import { SearchService } from 'src/app/service/search-service/search-service';
import { TaskService } from 'src/app/service/task-service/task-service';
import { Task } from 'src/app/model/task';
import { TASK_TABLE_HEADERS } from 'src/app/model/task-table';
import { SearchCriteria } from 'src/app/model/search';
import { environment } from 'src/environment/environment.development';
import { DataInsertion } from 'src/database/datainsertion';

@Component({
  selector: 'app-home',
  imports: [SearchComponent, TableComponent],
  templateUrl: './home.html',
  styleUrls: ['./home.scss'],
})
export class Home implements OnInit {
  public tableHeaders: (keyof Task)[] = TASK_TABLE_HEADERS;
  public taskToDisplay?: Task[];

  constructor(
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
}
