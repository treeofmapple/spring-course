import { Injectable } from '@angular/core';
import { Task } from 'src/app/model/task';
import { TaskService } from '../task-service/task-service';
import { SearchCriteria } from 'src/app/model/search';

@Injectable({
  providedIn: 'root',
})
export class SearchService {
  constructor(private taskService: TaskService) {}

  searchTasks(criteria: SearchCriteria): Task[] {
    let results = this.taskService.getTasks();

    if (criteria.id != null && !isNaN(criteria.id)) {
      results = results.filter((task) => task.id === criteria.id);
    }

    if (criteria.taskName && criteria.taskName.trim() !== '') {
      const lowercasedTerm = criteria.taskName.toLowerCase();
      results = results.filter((task) =>
        task.taskName.toLowerCase().includes(lowercasedTerm)
      );
    }
    return results;
  }
}
