import {Component} from "@angular/core";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './main.html'
})

export class MainClass {
  constructor(private router: Router) {
  }

  openForm(type:string)
  {
    this.router.navigateByUrl(type);
  }
}
