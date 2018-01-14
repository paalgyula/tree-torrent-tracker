import { Component, OnInit } from '@angular/core';
import { Torrent } from '../../shared/domain/torrent';
import { TorrentsService } from '../../shared';

@Component({
    selector: 'app-search',
    templateUrl: './search.component.html',
    styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

    public torrents: Torrent[];

    constructor(private torrentsService: TorrentsService) { }

    ngOnInit() {
        this.torrentsService.getTorrents()
            .subscribe(next => this.torrents = next);
    }

}
