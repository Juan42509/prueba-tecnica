import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaRepodiccionEliminarComponent } from './lista-repodiccion-eliminar.component';

describe('ListaRepodiccionEliminarComponent', () => {
  let component: ListaRepodiccionEliminarComponent;
  let fixture: ComponentFixture<ListaRepodiccionEliminarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaRepodiccionEliminarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaRepodiccionEliminarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
