import { Component, Input } from '@angular/core';
import { Guitar } from '../guitar';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';

@Component({
  selector: 'app-guitar-cards',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatChipsModule],
  templateUrl: './guitar-cards.component.html',
  styleUrls: ['./guitar-cards.component.scss']
  // styleUrl: './guitar-cards.component.css'
})
export class GuitarCardsComponent {
  @Input() guitar?: Guitar;
}
