import { Component, OnInit } from '@angular/core';
import { TrackerUser } from '../shared/domain/tracker-user';
import { UserService } from '../shared';

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
