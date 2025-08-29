import { Task } from './task';

export const TASK_TABLE_HEADERS: (keyof Task)[] = [
  'id',
  'taskName',
  'task',
  'assignedTo',
  'status',
  'startDate',
  'dueDate',
] as const;

export const TASK_HEADER_LABELS: Record<keyof Task, string> = {
  id: 'ID',
  taskName: 'Task Name',
  task: 'Description',
  assignedTo: 'Assigned To:',
  status: 'Status',
  startDate: 'Start Date',
  dueDate: 'Due Date',
};