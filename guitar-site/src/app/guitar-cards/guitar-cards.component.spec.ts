import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuitarCardsComponent } from './guitar-cards.component';

describe('GuitarCardsComponent', () => {
  let component: GuitarCardsComponent;
  let fixture: ComponentFixture<GuitarCardsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuitarCardsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GuitarCardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
