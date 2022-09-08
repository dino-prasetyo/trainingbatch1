import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-to-do-list',
  templateUrl: './to-do-list.component.html',
  styleUrls: ['./to-do-list.component.css']
})
export class ToDoListComponent{

  title = 'angular-to-do-list';
  desc: any;
  data: any = [];

  saveTask() {
    this.data['item'].unshift({
      id : Math.floor((Math.random()*1000)+1),
      description: this.desc,
      status: 0
    })
    localStorage.clear();
    localStorage.setItem("localStorage",JSON.stringify({item: this.data['item']}));
  }

}
