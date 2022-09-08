import {Component} from '@angular/core';

@Component({
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent {

  title = 'angular_1';
  textSample = 'sdfjskfkjsbnkjfbdsjkfbsdbf';
  isDisabled = false;

  keydown(e:any)
  {
    this.textSample =e.target.value;
  }

}
