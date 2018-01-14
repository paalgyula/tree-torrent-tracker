import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewsComponent } from './news/news.component';
import { LoginComponent } from './login/login.component';
import { SearchComponent } from './torrents/search/search.component';
import { LoginGuard } from './login.guard';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
    //{ path: 'Torrents/Search', component: SearchComponent, canActivate: [LoginGuard] },
    { path: 'Login', component: LoginComponent },
    { path: 'Register', component: RegisterComponent },
    { path: 'News', component: NewsComponent, canActivate: [LoginGuard] },
    { path: '**', redirectTo: 'Login' },
    { path: 'Torrents', loadChildren: 'torrent/torrent.module#TorrentModule', canLoad: [LoginGuard] }
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
