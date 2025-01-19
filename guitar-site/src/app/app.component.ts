import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GuitarFormComponent } from "./guitar-form/guitar-form.component";
import { GuitarCardsComponent } from "./guitar-cards/guitar-cards.component";
import { CommonModule } from '@angular/common';

import { GuitarCardsService } from './guitar-cards/guitar-cards.service';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, GuitarFormComponent, GuitarCardsComponent, CommonModule, MatProgressSpinnerModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})


export class AppComponent {
  title = 'Guitar Lookup: Explore Guitar Details and Specs ';
  dataLoading: boolean = false;
  selectedBrand: string = "";

  constructor(private guitarCardsService: GuitarCardsService) {}
  
  ngOnInit() {
    this.guitarCardsService.fetchingData.subscribe(isFetching => {
      this.dataLoading = isFetching;
    })
  }
  
  fillSearch(brand: string) {
    // console.log("Searching brand: " + brand);
    this.selectedBrand = brand;
  }
}