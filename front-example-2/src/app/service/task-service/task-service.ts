import { Injectable } from '@angular/core';
import { Task, TaskCreationData } from 'src/app/model/task';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private tasks?: Task[];

  getTasks(): Task[] {
    return this.tasks ?? [];
  }
}
