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
