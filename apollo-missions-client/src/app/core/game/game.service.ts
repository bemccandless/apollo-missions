import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { GameState } from './game-state';
import { tap } from 'rxjs/operators';
import { PlayerType } from '../../player/player-type.enum';
import { HostGameRequest } from '../../game-setup/host-game-request';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  public gameStateSubject = new BehaviorSubject<GameState>({} as GameState);
  public savingGameStateSubject = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient) { }

  public hostGame(playerLimit: number, playerName: string, playerType: PlayerType): Observable<GameState> {
    const hostGameRequest = new HostGameRequest();
    hostGameRequest.playerLimit = playerLimit;
    hostGameRequest.playerName = playerName;
    hostGameRequest.playerType = playerType;

    this.savingGameStateSubject.next(true);

    return this.http.post<GameState>('/api/game-setup', hostGameRequest)
      .pipe(
        tap(gameState => {
          this.gameStateSubject.next(gameState);
          this.savingGameStateSubject.next(false);
        })
      );
  }
}
