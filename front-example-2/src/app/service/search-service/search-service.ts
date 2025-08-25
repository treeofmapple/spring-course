import { Injectable } from '@angular/core';
import { Task } from 'src/app/model/task';
import { TaskService } from '../task-service/task-service';

@Injectable({
  providedIn: 'root',
})
export class SearchService {
  constructor(private taskService: TaskService) {}

  searchTasks(searchTerm: string): Task[] {
    const allTasks = this.taskService.getTasks();

    if (!searchTerm.trim()) {
      return allTasks;
    }

    const lowercasedTerm = searchTerm.toLowerCase();

    return allTasks.filter((task) => {
      const startDateString = task.startDate.toLocaleDateString().toLowerCase();
      const dueDateString = task.dueDate.toLocaleDateString().toLowerCase();

      return (
        task.taskName.toLowerCase().includes(lowercasedTerm) ||
        task.assignedTo.toLowerCase().includes(lowercasedTerm) ||
        task.status.toLowerCase().includes(lowercasedTerm) ||
        startDateString.includes(lowercasedTerm) ||
        dueDateString.includes(lowercasedTerm)
      );
    });
  }
}
