import { Component } from '@angular/core';
import { Guitar } from '../guitar';
import { CommonModule } from '@angular/common';
import { GuitarService } from '../guitar.service';


@Component({
  selector: 'app-guitars',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './guitars.component.html',
  styleUrl: './guitars.component.css'
})

export class GuitarsComponent {
  guitars: Guitar[] = [];

  constructor(private guitarService: GuitarService) {}

  // ngOnInit(): void {
  //   this.guitarService.getGuitars([]).subscribe((guitars) => {
  //     this.guitars = guitars;
  //   });
  // }
}
