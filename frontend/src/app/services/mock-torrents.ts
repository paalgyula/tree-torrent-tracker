import { Torrent } from '../domain/torrent';

export const TORRENTS: Torrent[] = [{
    id: 1,
    name: 'Test Torrent',
    uploaded: '2012.12.01 22:31',
    downloaded: 154,
    seeders: 2,
    leechers: 41,
    size: 5124523121,
    category: {
        img: 'xxx',
        name: 'porn'
    }
}, {
    id: 2,
    name: 'Test Torrent',
    uploaded: '2018.01.12 20:12',
    downloaded: 314,
    seeders: 14,
    leechers: 92,
    size: 734512512,
    category: {
        img: 'xxx',
        name: 'porn'
    }
}];
