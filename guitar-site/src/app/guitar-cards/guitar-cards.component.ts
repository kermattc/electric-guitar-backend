import { Component, Input } from '@angular/core';
import { Guitar } from '../guitar';

@Component({
  selector: 'app-guitar-cards',
  standalone: true,
  imports: [],
  templateUrl: './guitar-cards.component.html',
  styleUrl: './guitar-cards.component.css'
})
export class GuitarCardsComponent {
  @Input() guitar?: Guitar;
}
