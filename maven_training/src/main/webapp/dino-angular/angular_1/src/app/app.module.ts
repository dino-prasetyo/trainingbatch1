import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';

import {AppComponent} from './app.component';
import {StudentRegistration} from "./student-registration";
import {RouterModule, Routes} from "@angular/router";
import {MainClass} from "./main-class";
import {MataPelajaranComponent} from './mata-pelajaran/mata-pelajaran.component';
import {DesaFormComponent} from './desa-form/desa-form.component';
import {Authorization} from "./security/authorization.service";
import {Kiri} from "./kiri";

export const routes: Routes = [

  {
    path: "kiri",
    component: Kiri,
    children: [
      {
        path: "desa",
        component: DesaFormComponent,
        outlet: "kiri"
      }
    ]
  },

  {
    path: "app",
    component: AppComponent,
    outlet: "kanan"
  },
  {
    path: "student",
    component: StudentRegistration,
    outlet: "kanan"
  },

]

@NgModule({
  declarations: [
    MainClass,
    AppComponent,
    StudentRegistration,
    MataPelajaranComponent,
    DesaFormComponent
  ],
  imports: [
    BrowserModule
    , RouterModule.forRoot(routes)
    , HttpClientModule
  ],
  providers: [Authorization],
  bootstrap: [MainClass],
  exports: [RouterModule]
})

export class AppModule {
}
