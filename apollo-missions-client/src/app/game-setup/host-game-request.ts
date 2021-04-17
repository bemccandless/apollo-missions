import { PlayerType } from '../player/player-type.enum';

export class HostGameRequest {

  playerLimit: number;
  playerName: string;
  playerType: PlayerType;

}
