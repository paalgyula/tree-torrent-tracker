import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { TORRENTS } from './mock-torrents';
import { Torrent } from '../../shared/domain';

@Injectable()
export class TorrentsService {

    public getTorrents(page?: number): Observable<Torrent[]> {
        return of(TORRENTS);
    }

    constructor() { }
}
