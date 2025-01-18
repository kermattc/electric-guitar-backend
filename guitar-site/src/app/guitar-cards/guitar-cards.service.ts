import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GuitarCardsService {
  private visibleCardsSubject = new BehaviorSubject<number>(4);
  visibleCards$ = this.visibleCardsSubject.asObservable();

  showMore() {
    this.visibleCardsSubject.next(this.visibleCardsSubject.value + 4);
  }
}
