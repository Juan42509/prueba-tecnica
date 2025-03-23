import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListasReproduccionCreacionComponent } from './listas-reproduccion-creacion.component';

describe('ListasReproduccionCreacionComponent', () => {
  let component: ListasReproduccionCreacionComponent;
  let fixture: ComponentFixture<ListasReproduccionCreacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListasReproduccionCreacionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListasReproduccionCreacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
