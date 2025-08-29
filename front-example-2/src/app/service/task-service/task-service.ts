import { Injectable } from '@angular/core';
import { Task, TaskCreationData } from 'src/app/model/task';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private tasks?: Task[];

  private lastId = 0;

  addTask(data: TaskCreationData): Task {
    this.lastId++;

    const newId = this.lastId;

    const newTask: Task = {
      id: newId,

      ...data,
    };

    if (!this.tasks) {
      this.tasks = [];
    }

    this.tasks.push(newTask);

    return newTask;
  }

  getTasks(): Task[] {
    return this.tasks ?? [];
  }
}
