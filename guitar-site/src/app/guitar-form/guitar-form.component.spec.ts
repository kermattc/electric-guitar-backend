import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuitarFormComponent } from './guitar-form.component';

describe('GuitarFormComponent', () => {
  let component: GuitarFormComponent;
  let fixture: ComponentFixture<GuitarFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuitarFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GuitarFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
