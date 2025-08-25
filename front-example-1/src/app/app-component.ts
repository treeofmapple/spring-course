import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [FormsModule],
  templateUrl: './app-component.html',
  styleUrls: ['./app-component.scss', './app-boxes.scss']
})
export class AppComponent {
  protected message?: string;
  protected messageStored?: string;

  submitMessage(event?: KeyboardEvent): void {
    if(event) {
      event.preventDefault();
    }

    if(this.message && this.message.trim() != '') {
      this.messageStored = this.message
    }
    this.message = "";
  }

}
