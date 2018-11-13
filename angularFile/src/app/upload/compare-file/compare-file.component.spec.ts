import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompareFileComponent } from './compare-file.component';

describe('CompareFileComponent', () => {
  let component: CompareFileComponent;
  let fixture: ComponentFixture<CompareFileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompareFileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompareFileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
