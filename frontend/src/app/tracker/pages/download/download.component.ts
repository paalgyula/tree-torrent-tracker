import { Component, OnInit } from '@angular/core';
import { Torrent } from '../../../shared/domain';
import { TorrentsService } from '../../../shared';

@Component({
    selector: 'app-search',
    templateUrl: './download.component.html',
    styleUrls: []
})
export class DownloadComponent implements OnInit {

    public torrents: Torrent[];

    constructor(private torrentsService: TorrentsService) { }

    ngOnInit() {
        this.torrentsService.getTorrents()
            .subscribe(next => this.torrents = next);
    }

}
