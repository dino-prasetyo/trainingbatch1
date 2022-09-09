import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderBaruComponent } from './header-baru.component';

describe('HeaderBaruComponent', () => {
  let component: HeaderBaruComponent;
  let fixture: ComponentFixture<HeaderBaruComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeaderBaruComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HeaderBaruComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
