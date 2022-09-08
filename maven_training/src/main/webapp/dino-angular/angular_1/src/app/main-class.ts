import {Component} from "@angular/core";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  template: ' <div>\n' +
    '  <button (click)="openStudentRegistration(\'student\')" tabindex="0">\n' +
    '          <span>Open Student Form</span>\n' +
    '        </button>\n' +
    ' <button (click)="openStudentRegistration(\'app\')" tabindex="0">\n' +
    '          <span>Open App</span>\n' +
    '        </button>\n' +
    '   <router-outlet></router-outlet>\n' +
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
