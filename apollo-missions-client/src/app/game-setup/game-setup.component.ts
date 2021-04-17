import { Component, OnInit } from '@angular/core';
import { GameService } from '../core/game/game.service';
import { PlayerType } from '../player/player-type.enum';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'app-game-setup',
  templateUrl: './game-setup.component.html',
  styleUrls: ['./game-setup.component.scss']
})
export class GameSetupComponent implements OnInit {

  public playerName: string;
  public playerLimit: number;
  public playerType: PlayerType;

  public savingGameState: boolean;

  public FLIGHT_CONTROLLER = PlayerType.FLIGHT_CONTROLLER;
  public ASTRONAUT = PlayerType.ASTRONAUT;

  constructor(private gameService: GameService) {
    this.gameService.savingGameStateSubject.subscribe(saving => this.savingGameState = saving);
  }

  ngOnInit(): void { }

  public hostGame(): void {
    this.gameService.hostGame(
      this.playerLimit,
      this.playerName,
      this.playerType).pipe(
        finalize(() => {
          this.gameService.savingGameStateSubject.next(false)
        })
      ).subscribe();
  }

  public disableHostButton(): boolean {
    return this.savingGameState
      || this.playerName == null
      || this.playerName === ''
      || this.playerType == null
      || this.playerLimit == null;
  }

}
