import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewsComponent } from './news/news.component';
import { LoginComponent } from './login/login.component';
import { SearchComponent } from './torrents/search/search.component';
import { LoginGuard } from './login.guard';

const routes: Routes = [
    { path: 'Torrents/Search', component: SearchComponent, canActivate: [LoginGuard] },
    { path: 'Login', component: LoginComponent },
    { path: 'News', component: NewsComponent, canActivate: [LoginGuard] },
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
