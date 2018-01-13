import { Torrent } from '../torrents.service';

export const TORRENTS: Torrent[] = [{
    id: 1,
    name: 'Test Torrent',
    uploaded: 0.412,
    downloaded: 154.52,
    seeders: 0,
    leechers: 41,
    category: {
        img: 'xxx',
        name: 'porn'
    }
}, {
    id: 2,
    name: 'Test Torrent',
    uploaded: 12,
    downloaded: 314,
    seeders: 14,
    leechers: 92,
    category: {
        img: 'xxx',
        name: 'porn'
    }
}];
