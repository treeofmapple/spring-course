import { Component, Input } from '@angular/core';
import { Task } from '../model/task';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-table',
  imports: [CommonModule],
  templateUrl: './table-component.html',
  styleUrls: ['./table-component.scss'],
})
export class TableComponent {

  @Input() headers?: (keyof Task)[];
  @Input() data?: Task[];

  public getCellValue(row: Task, header: string): any {
    return (row as any)[header];
  }

}
