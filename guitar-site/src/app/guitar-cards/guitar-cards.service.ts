import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GuitarCardsService {
  private visibleCardsSubject = new BehaviorSubject<number>(4);
  private allGuitarsVisibleSubject = new BehaviorSubject<boolean>(false);
  private fetchingDataSubject = new BehaviorSubject<boolean>(false);

  visibleCards = this.visibleCardsSubject.asObservable();
  allGuitarsVisible = this.allGuitarsVisibleSubject.asObservable();
  fetchingData = this.fetchingDataSubject.asObservable();

  showMore(totalGuitars: number) {
    const currentVisibleCards = this.visibleCardsSubject.value + 4;
    this.visibleCardsSubject.next(currentVisibleCards);

    if (currentVisibleCards >= totalGuitars) {
        this.allGuitarsVisibleSubject.next(true);
    }
  }

  setLoadingState(isLoading: boolean) {
    this.fetchingDataSubject.next(isLoading);
  }

  resetVisibleCards() {
    this.visibleCardsSubject.next(4);
    this.allGuitarsVisibleSubject.next(false);
  }
}
