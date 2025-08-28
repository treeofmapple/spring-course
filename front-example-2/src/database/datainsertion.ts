import { TaskStatus } from "src/app/model/task-status";
import { TaskService } from "src/app/service/task-service/task-service";

export class DataInsertion {

    constructor(private taskService: TaskService) {}

    addMockTasks(): void {
    console.log('Loading mock data for development...');

    this.taskService.addTask({
      taskName: 'Setup Project',
      task: 'Initialize the Angular repository and install dependencies.',
      assignedTo: 'Alice',
      status: TaskStatus.Done,
      startDate: new Date('2025-08-25'),
      dueDate: new Date('2025-08-26')
    });

    this.taskService.addTask({
      taskName: 'Create Components',
      task: 'Build the main search and table components.',
      assignedTo: 'Bob',
      status: TaskStatus.Pending,
      startDate: new Date('2025-08-27'),
      dueDate: new Date('2025-09-05')
    });
    
    this.taskService.addTask({
      taskName: 'Deploy to Staging',
      task: 'Deploy the first version to the staging server.',
      assignedTo: 'Alice',
      status: TaskStatus.Pending,
      startDate: new Date('2025-09-08'),
      dueDate: new Date('2025-09-10')
    });
  }

}