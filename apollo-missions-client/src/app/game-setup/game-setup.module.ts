import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GameSetupComponent } from './game-setup.component';
import { MaterialModule } from '../core/material/material.module';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    GameSetupComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    MaterialModule,
    AppRoutingModule,
    FormsModule
  ]
})
export class GameSetupModule { }
