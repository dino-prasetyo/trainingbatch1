import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { ToDoListComponent } from "./to-do-list/to-do-list.component";

const appRoutes: Routes = [
  { path: '',     component:  HomeComponent },
  { path: 'about',  component:  AboutComponent},
  { path: 'contact',  component:  ContactComponent},
  { path: 'to-do-list', component: ToDoListComponent },
  { path: '**',   redirectTo: ''}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
