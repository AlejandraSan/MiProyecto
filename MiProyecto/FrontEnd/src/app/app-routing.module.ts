import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
const routes: Routes = [
  /*aplica el ruteo, en el path, y que vaya a HomeComponent
   */
  {path:'', component: HomeComponent}, 
/* si estoy en localhost:/login, me lleva a loginComponent */
  {path:'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes),NgCircleProgressModule.forRoot({})],
  exports: [RouterModule],
  
})
export class AppRoutingModule { }
