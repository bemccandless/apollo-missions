import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatDividerModule } from '@angular/material/divider';
import { MatInputModule } from '@angular/material/input';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatProgressBarModule } from '@angular/material/progress-bar';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatDialogModule,
    MatDividerModule,
    MatInputModule,
    MatButtonToggleModule,
    MatProgressBarModule
  ],
  exports: [
    MatButtonModule,
    MatDialogModule,
    MatDividerModule,
    MatInputModule,
    MatButtonToggleModule,
    MatProgressBarModule
  ]
})
export class MaterialModule { }
