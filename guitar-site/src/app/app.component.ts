import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GuitarsComponent } from "./guitars/guitars.component";
import { GuitarFormComponent } from "./guitar-form/guitar-form.component";
import { GuitarCardsComponent } from "./guitar-cards/guitar-cards.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, GuitarsComponent, GuitarFormComponent, GuitarCardsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Guitar Lookup';
}
