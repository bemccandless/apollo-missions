import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlayerSelectionComponent } from './player-selection.component';
import { MaterialModule } from '../core/material/material.module';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';



@NgModule({
  declarations: [
    PlayerSelectionComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    MatDividerModule,
    MatButtonModule,
    MatDialogModule
  ]
})
export class PlayerSelectionModule { }
