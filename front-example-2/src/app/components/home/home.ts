import { Component } from '@angular/core';
import { TableComponent } from '../table/table-component';
import { SearchComponent } from '../search/search-component';

@Component({
  selector: 'app-home',
  imports: [SearchComponent, TableComponent],
  templateUrl: './home.html',
  styleUrls: ['./home.scss'],
})
export class Home {


  

}
