import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import {PlayerSelectionComponent} from './player-selection/player-selection.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  public hostGameSelected = false;

  constructor(private dialog: MatDialog) {
  }

  public openPlayerSelectionDialog(): void {
    this.dialog.open(PlayerSelectionComponent);
  }

}
