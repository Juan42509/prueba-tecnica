import { TestBed } from '@angular/core/testing';

import { ListaReproduccionService } from './lista-reproduccion.service';

describe('ListaReproduccionService', () => {
  let service: ListaReproduccionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListaReproduccionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
