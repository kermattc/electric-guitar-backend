import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GuitarsComponent } from "./guitars/guitars.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, GuitarsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'guitar-site';
}
