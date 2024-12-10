import { Component } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { debounceTime, distinct, distinctUntilChanged, map } from 'rxjs/operators';

@Component({
  selector: 'app-guitar-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './guitar-form.component.html',
  styleUrl: './guitar-form.component.css'
})
export class GuitarFormComponent {
  searchControl = new FormControl('');
  constructor() {}

  // look for changes every 300 ms
  // turn string into array of strings so i can pass it into the api later
    // remove leading/trailing whitespace -> turn string into array (comma delimieter) -> remove leading/trailing whitespace for each item -> remove empty strings
  ngOnInit() {
    this.searchControl.valueChanges.pipe(
        debounceTime(300),
        distinctUntilChanged(),
      )
      .subscribe((value: string | null) => {
        const keywords = new Set (
          value?.trim()
          .split(",")
          .map(keyword => keyword.trim())
          .filter(keyword => keyword.length > 0)
        );

        console.log("Keywords:", keywords);
      });
  }
}

