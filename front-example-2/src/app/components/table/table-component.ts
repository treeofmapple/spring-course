import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Task } from 'src/app/model/task';
import { TASK_HEADER_LABELS } from 'src/app/model/task-table';

@Component({
  selector: 'app-table',
  imports: [CommonModule],
  templateUrl: './table-component.html',
  styleUrls: ['./table-component.scss'],
})
export class TableComponent {
  @Input() headers?: (keyof Task)[];
  @Input() data?: Task[];

  public getHeaderLabel(headerKey: keyof Task): string {
    return TASK_HEADER_LABELS[headerKey] || headerKey;
  }

  public getCellValue(row: Task, header: string): any {
    return (row as any)[header];
  }
}
