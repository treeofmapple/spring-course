import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-search',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './search-component.html',
  styleUrls: ['./search-component.scss'],
})
export class SearchComponent {
  
  @Output() searchChanged = new EventEmitter<string>();
  searchControl = new FormControl('');

  onSearch(): void {
    this.searchChanged.emit(this.searchControl.value ?? '');
  }

  clearSearch(): void {
    this.searchControl.setValue('');
    this.searchChanged.emit('');
  }
}
