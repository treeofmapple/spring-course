import { TaskStatus } from "./task-status";

export interface Task {
  id: number;
  taskName: string;
  task: string;
  assignedTo: string;
  status: TaskStatus;
  startDate: Date;
  dueDate: Date;
}

export type TaskCreationData = Omit<Task, 'id'>;
