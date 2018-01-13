import { Component, OnInit } from '@angular/core';
import { TrackerUser } from '../domain/tracker-user';
import { LoginService } from '../login/login.service';

@Component({
    selector: 'app-menu',
    templateUrl: './menu.component.html',
    styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

    public trackerUser: TrackerUser;

    constructor(private loginService: LoginService) {
    }

    ngOnInit() {
        this.loginService.userChange.subscribe(user => {
            this.trackerUser = user;
            console.log(user);
        });
    }
}
