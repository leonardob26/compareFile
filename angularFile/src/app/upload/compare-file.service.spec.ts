import { TestBed } from '@angular/core/testing';

import { CompareFileService } from './compare-file.service';

describe('CompareFileService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CompareFileService = TestBed.get(CompareFileService);
    expect(service).toBeTruthy();
  });
});
