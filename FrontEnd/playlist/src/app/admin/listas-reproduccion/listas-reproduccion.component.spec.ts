import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListasReproduccionComponent } from './listas-reproduccion.component';

describe('ListasReproduccionComponent', () => {
  let component: ListasReproduccionComponent;
  let fixture: ComponentFixture<ListasReproduccionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListasReproduccionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListasReproduccionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
