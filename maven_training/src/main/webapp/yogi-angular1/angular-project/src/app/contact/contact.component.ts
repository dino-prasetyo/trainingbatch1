import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  message = " default value"
  keydown(e:any)
  {
    this.message =e.target.value;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
