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
