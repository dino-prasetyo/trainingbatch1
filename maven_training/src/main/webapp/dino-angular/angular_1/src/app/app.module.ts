import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {StudentRegistration} from "./student-registration";
import {RouterModule, Routes} from "@angular/router";
import {MainClass} from "./main-class";
import { MataPelajaranComponent } from './mata-pelajaran/mata-pelajaran.component';

export const routes : Routes = [
  {
    path : "app",
    component : AppComponent
  },
  {
    path : "student",
    component : StudentRegistration
  }
]
@NgModule({
  declarations: [
    MainClass,
    AppComponent,
    StudentRegistration,
    MataPelajaranComponent
  ],
  imports: [
    BrowserModule
    , RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [MainClass],
  exports: [RouterModule]
})

export class AppModule { }
