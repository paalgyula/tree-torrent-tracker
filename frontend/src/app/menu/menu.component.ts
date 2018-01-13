import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-menu',
    templateUrl: './menu.component.html',
    styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

    public trackerUser: {
        username: string,
        title: string,
        points: number,
        uploaded: number,
        downloaded: number
    };

    constructor() {
        this.trackerUser = {
            username: 'demoUser',
            title: 'Newb',
            points: 0,
            uploaded: 0.00,
            downloaded: 0.00
        };
    }

    ngOnInit() {
    }

}
