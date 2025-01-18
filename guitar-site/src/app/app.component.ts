import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GuitarFormComponent } from "./guitar-form/guitar-form.component";
import { GuitarCardsComponent } from "./guitar-cards/guitar-cards.component";
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, GuitarFormComponent, GuitarCardsComponent, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Guitar Lookup';
}
