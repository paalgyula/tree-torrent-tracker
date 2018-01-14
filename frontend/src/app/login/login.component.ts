import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

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

    constructor(private userService: UserService,
        private router: Router) { }

    ngOnInit() {
        if (this.userService.isLoggedIn) {
            this.router.navigate(['News']);
        }

        this.logindata = { username: '', password: '', remember: false };
    }

    public onSubmit(): void {
        this.userService.login(this.logindata.username, this.logindata.password);
    }

}
