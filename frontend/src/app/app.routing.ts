import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {LoginGuard} from './login.guard';
import {RegisterComponent} from './register/register.component';

const routes: Routes = [
    {path: 'Login', component: LoginComponent},
    {path: 'Register', component: RegisterComponent},
    {path: 'Tracker', loadChildren: './tracker/tracker.module#TrackerModule', canLoad: [LoginGuard]}
    // { path: '**', redirectTo: 'Login' }
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, { enableTracing: true })
    ],
    exports: [
        RouterModule
    ],
    declarations: []
})
export class AppRoutingModule {
}
