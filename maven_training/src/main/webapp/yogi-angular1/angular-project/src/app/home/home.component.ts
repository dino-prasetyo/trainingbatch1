import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  nama = "Yogi Anggoro"
  isDisabled = true;
  constructor() { }

  getTittle(){
    return "here is a tittle";
            }
  ngOnInit(): void {
  }

}
