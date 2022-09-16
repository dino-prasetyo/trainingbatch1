import {Component} from "@angular/core";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  template: '<div class="row"> <div class="container center-block">\n' +
    '  <button class="col-md-2" (click)="openStudentRegistration(\'desa\')" tabindex="0">\n' +
    '          <span>Open Desa Form</span>\n' +
    '        </button>\n' +
    '  <button class="col-md-2" (click)="openStudentRegistration(\'student\')" tabindex="0">\n' +
    '          <span>Open Student Form</span>\n' +
    '        </button>\n' +
    ' <button class="col-md-2" (click)="openStudentRegistration(\'app\')" tabindex="0">\n' +
    '          <span>Open App</span>\n' +
    '        </button>\n' +
    '  </div></div>' +
    '<div class="row"> <router-outlet></router-outlet>\n' +
    '  </div>'
})

export class MainClass {
  constructor(private router: Router) {
  }

  openStudentRegistration(type:string)
  {
    this.router.navigate([type]);
  }
}
