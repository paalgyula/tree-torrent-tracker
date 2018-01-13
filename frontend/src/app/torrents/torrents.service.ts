import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import {TORRENTS} from './mock-torrents';

export class Torrent {
    id: number;
    name: string;
    uploaded: string;
    downloaded: number;
    seeders: number;
    leechers: number;
    size: number;
    category?: { name: string, img: string };
}

@Injectable()
export class TorrentsService {

    public getTorrents(): Observable<Torrent[]> {
        return of(TORRENTS);
    }

    constructor() { }
}
