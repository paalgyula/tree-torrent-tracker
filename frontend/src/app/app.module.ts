import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { NewsComponent } from './news/news.component';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';
import { LoginGuard } from './login.guard';
import { RegisterComponent } from './register/register.component';
import { UserService } from './services/user.service';
import { TorrentsService } from './services/torrents.service';
import { SharedModule } from './shared/shared.module';
import { ByteformatPipe } from './shared/pipes/byteformat.pipe';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    NewsComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AppRoutingModule,
    SharedModule
  ],
  providers: [TorrentsService, UserService, LoginGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
