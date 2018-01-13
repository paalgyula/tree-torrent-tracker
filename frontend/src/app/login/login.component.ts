import { Component, OnInit, ViewChild } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    public logindata: {
        username: string,
        password: string,
        remember: boolean
    };

    constructor(private loginService: LoginService,
        private router: Router) { }

    ngOnInit() {
        if (this.loginService.isLoggedIn) {
            this.router.navigate(['News']);
        }

        this.logindata = { username: '', password: '', remember: false };
    }

    public onSubmit(): void {
        this.loginService.login(this.logindata.username, this.logindata.password);
    }

}
