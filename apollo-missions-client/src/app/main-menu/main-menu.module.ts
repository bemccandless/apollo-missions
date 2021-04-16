import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainMenuComponent } from './main-menu.component';
import { MaterialModule } from '../core/material/material.module';
import { AppRoutingModule } from '../app-routing.module';



@NgModule({
  declarations: [MainMenuComponent],
  imports: [
    CommonModule,
    MaterialModule,
    AppRoutingModule
  ]
})
export class MainMenuModule { }
