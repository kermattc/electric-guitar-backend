import { Component, Input } from '@angular/core';
import { Guitar } from '../guitar';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { MatDividerModule } from '@angular/material/divider';
import { MatExpansionModule } from "@angular/material/expansion";
import { CommonModule } from '@angular/common';

import { GuitarCardsService } from './guitar-cards.service';

@Component({
  selector: 'app-guitar-cards',
  standalone: true,
  imports: [MatCardModule, MatChipsModule, MatDividerModule, MatExpansionModule, CommonModule],
  templateUrl: './guitar-cards.component.html',
  styleUrls: ['./guitar-cards.component.scss']
})

export class GuitarCardsComponent {
  constructor(private guitarCardsService: GuitarCardsService) {}
  isFlipped: boolean = false;
  rotationAngle = 0;

  @Input() guitar?: Guitar;

  showMore() {
    this.guitarCardsService.showMore();
  }

  brandLogos: { [key: string]: string} = {
    Fender: '../assets/images/fender-logo.svg',
    Gibson: '../assets/images/gibson-logo.png',
    Gretsch: '../assets/images/gretsch-logo.png',
    Ibanez: '../assets/images/ibanez-logo.svg',
    Martin: '../assets/images/martin-logo.png',
    Taylor: '../assets/images/taylor-logo.png',

  }

  getBrandLogo(brand: string):string {
    return this.brandLogos[brand];
  }

  guitarImages: { [key: string]: string } = {
    'fender-stratocaster': '../assets/guitars/fender-stratocaster.png',
    'fender-coronado': '../assets/guitars/fender-coronado.png',
    'fender-duo-sonic': '../assets/guitars/fender-duo-sonic.png',
    'fender-jaguar': '../assets/guitars/fender-jaguar.png',
    'fender-jazz-bass-(j-bass)': '../assets/guitars/fender-jazz-bass.png',
    'fender-jazzmaster': '../assets/guitars/fender-jazzmaster.png',
    'fender-marauder': '../assets/guitars/fender-marauder.png',
    'fender-mustang': '../assets/guitars/fender-mustang.png',
    'fender-precision-bass-(p-bass)': '../assets/guitars/fender-precision-bass.png',
    'fender-squier': '../assets/guitars/fender-squier.png',
    'fender-starcaster': '../assets/guitars/fender-starcaster.png',
    'fender-telecaster': '../assets/guitars/fender-telecaster.png',
    'gibson-blueshawk': '../assets/guitars/epiphone-blueshawk.png',
    'gibson-es-175': '../assets/guitars/gibson-es-175.png',
    'gibson-es-335': '../assets/guitars/gibson-es-335.png',
    'gibson-explorer': '../assets/guitars/gibson-explorer.png',
    'gibson-firebird': '../assets/guitars/gibson-firebird.png',
    'gibson-flying-v': '../assets/guitars/gibson-flying-v.png',
    'gibson-les-paul': '../assets/guitars/gibson-les-paul.png',
    'gibson-melody-maker': '../assets/guitars/gibson-melody-maker.png',
    'gibson-sg': '../assets/guitars/gibson-sg.png',
    'gretsch-anniversary': '../assets/guitars/gretsch-anniversary.png',
    'gretsch-country-gentleman': '../assets/guitars/gretsch-country-gentleman.png',
    'gretsch-duo-jet': '../assets/guitars/gretsch-duo-jet.png',
    'gretsch-electromatic': '../assets/guitars/gretsch-electromatic.png',
    'gretsch-g2655t': '../assets/guitars/gretsch-g2655t.png',
    'gretsch-g6120': '../assets/guitars/gretsch-g6120.png',
    'gretsch-jet-firebird': '../assets/guitars/gretsch-jet-firebird.png',
    'gretsch-streamliner': '../assets/guitars/gretsch-streamliner.png',
    'gretsch-white-falcon': '../assets/guitars/gretsch-white-falcon.png',
    'ibanez-artcore-af75': '../assets/guitars/ibanez-artcore-af75.png',
    'ibanez-artcore-as73': '../assets/guitars/ibanez-artcore-as73.png',
    'ibanez-grgm21m': '../assets/guitars/ibanez-grgm21m.png',
    'ibanez-grx70qa': '../assets/guitars/ibanez-grx70qa.png',
    'ibanez-iron-label-rgaix6u': '../assets/guitars/ibanez-iron-label-rgaix6u.png',
    'ibanez-jem7v': '../assets/guitars/ibanez-jem7v.png',
    'ibanez-rg421': '../assets/guitars/ibanez-rg421.png',
    'ibanez-s521': '../assets/guitars/ibanez-s521.png',
    'ibanez-sr505': '../assets/guitars/ibanez-sr505.png',
  }

  getGuitarImage(model: string): string {
    model = model.split(' ').join('-').toLowerCase();
    return this.guitarImages[model] || 'assets/guitars/free-guitar.png';
  }

  toggleFlip() {
    this.isFlipped = !this.isFlipped;
  }

  rotateChevron() {
    this.rotationAngle += 180;
  }
}
