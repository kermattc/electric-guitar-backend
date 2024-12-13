import { Component, Input } from '@angular/core';
import { Guitar } from '../guitar';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { MatDividerModule } from '@angular/material/divider';

@Component({
  selector: 'app-guitar-cards',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatChipsModule, MatDividerModule],
  templateUrl: './guitar-cards.component.html',
  styleUrls: ['./guitar-cards.component.scss']
})
export class GuitarCardsComponent {
  @Input() guitar?: Guitar;
}
