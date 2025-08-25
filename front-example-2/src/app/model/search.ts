import { TaskStatus } from "./task-status";

export interface SearchCriteria {
  taskName?: string;
  assignedTo?: string;
  status?: TaskStatus;
  dueDate?: string;
}