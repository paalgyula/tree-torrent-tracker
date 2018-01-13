import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewsComponent } from './news/news.component';
import { LoginComponent } from './login/login.component';
import { SearchComponent } from './torrents/search/search.component';

const routes: Routes = [
    { path: 'Torrents/Search', component: SearchComponent },
    { path: 'Login', component: LoginComponent },
    { path: 'News', component: NewsComponent },
    { path: '*', component: NewsComponent }
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
