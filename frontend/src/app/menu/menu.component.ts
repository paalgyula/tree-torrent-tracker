import { Component, OnInit } from '@angular/core';
import { TrackerUser } from '../domain/tracker-user';
import { UserService } from '../services/user.service';

@Component({
    selector: 'app-menu',
    templateUrl: './menu.component.html',
    styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

    public trackerUser: TrackerUser;

    constructor(private userService: UserService) {
    }

    ngOnInit() {
        this.userService.userChange.subscribe(user => {
            this.trackerUser = user;
            console.log(user);
        });
    }
}
