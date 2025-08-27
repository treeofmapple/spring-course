import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { SearchComponent } from "./components/search/search-component";
import { TableComponent } from "./components/table/table-component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, SearchComponent, TableComponent],
  templateUrl: './app-component.html',
  styleUrls: ['./app-component.scss'],
})
export class AppComponent {

  constructor(private router: Router) {}

  navigateTo(path: string): void {
    this.router.navigate([path]);
  }

}
