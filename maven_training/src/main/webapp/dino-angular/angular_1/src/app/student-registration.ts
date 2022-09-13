import {Component, ElementRef, Input} from "@angular/core";
import {NgStyle} from '@angular/common';

@Component(
  {
    templateUrl: "student-registration.html"
  }
)
export class StudentRegistration {
  arrayOfNama = [
    {
      id: 1,
      nama: 'Nama 1'
    },

    {
      id: 2,
      nama: 'Nama 2'
    },
    {
      id: 3,
      nama: 'Nama 3'
    },

  ]
  display = false;

  ubahFlag() {
    this.display = !this.display;
  }

  cekNilai(): boolean {
    return this.display;
  }

  cekSwitch(){
    return 6;
  }
}
