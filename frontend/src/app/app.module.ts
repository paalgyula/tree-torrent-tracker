import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
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
import { LoginGuard } from './login.guard';
import { RegisterComponent } from './register/register.component';
import { UserService } from './services/user.service';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    NewsComponent,
    SearchComponent,
    ByteformatPipe,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [TorrentsService, UserService, LoginGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
