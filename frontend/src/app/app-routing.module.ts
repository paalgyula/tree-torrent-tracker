import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewsComponent } from './news/news.component';
import { LoginComponent } from './login/login.component';
import { LoginGuard } from './login.guard';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
    { path: 'Login', component: LoginComponent },
    { path: 'Register', component: RegisterComponent },
    { path: 'News', component: NewsComponent, canActivate: [LoginGuard] },
    { path: 'Torrents', pathMatch: 'prefix', loadChildren: './torrent/torrent.module#TorrentModule', canLoad: [LoginGuard] },
    { path: '**', redirectTo: 'Login' }
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ],
    declarations: []
})
export class AppRoutingModule { }
