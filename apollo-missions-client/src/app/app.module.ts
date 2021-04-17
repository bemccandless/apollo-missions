import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GameSetupModule } from './game-setup/game-setup.module';
import { MainMenuModule } from './main-menu/main-menu.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    GameSetupModule,
    MainMenuModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
