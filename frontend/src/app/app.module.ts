import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { NewsComponent } from './news/news.component';
import { AppRoutingModule } from './app-routing.module';
import { SearchComponent } from './torrents/search/search.component';
import { TorrentsService } from './torrents/torrents.service';
import { ByteformatPipe } from './pipes/byteformat.pipe';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    NewsComponent,
    SearchComponent,
    ByteformatPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [TorrentsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
