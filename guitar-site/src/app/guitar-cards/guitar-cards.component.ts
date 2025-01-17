import { Component, Input } from '@angular/core';
import { Guitar } from '../guitar';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { MatDividerModule } from '@angular/material/divider';
import { MatExpansionModule } from "@angular/material/expansion";

// import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
// import { library } from '@fortawesome/fontawesome-svg-core';
// import { faIndustry, faGuitar } from '@fortawesome/free-solid-svg-icons';

// library.add(faIndustry, faGuitar);

@Component({
  selector: 'app-guitar-cards',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatChipsModule, MatDividerModule, MatExpansionModule],
  templateUrl: './guitar-cards.component.html',
  styleUrls: ['./guitar-cards.component.scss']
})

export class GuitarCardsComponent {
  @Input() guitar?: Guitar;

  brandLogos: { [key: string]: string} = {
    Fender: '../assets/images/fender-logo.svg'
  }

  getBrandLogo(brand: string):string {
    return this.brandLogos[brand];
  }

  guitarImages: { [key: string]: string } = {
    'fender-stratocaster': '../assets/guitars/fender-stratocaster.png'
  }

  getGuitarImage(model: string): string {
    model = model.split(' ').join('-').toLowerCase();
    // console.log("looking for model: ", model)
    return this.guitarImages[model];
  }
}
