import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatEquipageComponent } from './stat-equipage.component';

describe('StatEquipageComponent', () => {
  let component: StatEquipageComponent;
  let fixture: ComponentFixture<StatEquipageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StatEquipageComponent]
    });
    fixture = TestBed.createComponent(StatEquipageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
