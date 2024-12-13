import { Component, ViewEncapsulation } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
import { GuitarService } from '../guitar.service';
import { GuitarCardsComponent } from "../guitar-cards/guitar-cards.component";
import { Guitar } from '../guitar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

type RGB = {
  r: number;
  g: number;
  b: number;
};

@Component({
  selector: 'app-guitar-form',
  standalone: true,
  encapsulation: ViewEncapsulation.None,
  imports: [ReactiveFormsModule, CommonModule, GuitarCardsComponent, MatFormFieldModule, MatInputModule],
  templateUrl: './guitar-form.component.html',
  styleUrls: ['./guitar-form.component.css', './guitar-form.component.scss']
})

export class GuitarFormComponent {
  searchControl = new FormControl('');
  constructor(private guitarService: GuitarService) {}

  guitarsList: Guitar[] = [];
  colors: string[] = [];

  // GuitarService guitarService = new GuitarService();
  // look for changes every 300 ms
  // turn string into array of strings so i can pass it into the api later
    // remove leading/trailing whitespace -> turn string into array (comma delimieter) -> remove leading/trailing whitespace for each item -> remove empty strings
  ngOnInit() {
    console.log("guitars list: ", this.guitarsList);
    this.searchControl.valueChanges.pipe(
        debounceTime(300),
        distinctUntilChanged(),
      )
      .subscribe((value: string | null) => {
        const keywords = Array.from(new Set (
          value?.trim()
          .split(",")
          .map(keyword => keyword.trim().replace(/\W/g, ''))  // tbd? added this to remove non alphanuemric characters
          .filter(keyword => keyword.length > 0)
        ).values());

        console.log("Keywords:", keywords);

        this.guitarService.getGuitars(keywords).subscribe( (guitars) => {
      
          this.guitarsList = guitars || [];
          
          this.guitarsList.forEach(guitar => {
            guitar.color = generateRandomColor(255,255, 255);

            
            // `rgb(${Math.floor(Math.random() * 256)}, 
            // ${Math.floor(Math.random() * 256)}, 
            // ${Math.floor(Math.random() * 256)})`
          })
      
          console.log("data: ", guitars);
 
        });
      });

      function generateRandomColor(r: number, g: number, b: number): string {
        let color=""
        let red = Math.floor(Math.random() * 256);
        let green = Math.floor(Math.random() * 256);
        let blue = Math.floor(Math.random() * 256);

        red = (red + r) / 2
        green = (green + g) / 2
        blue = (blue + b) / 2

        return `rgb(${red}, ${green}, ${blue})`;
      }
  }
}