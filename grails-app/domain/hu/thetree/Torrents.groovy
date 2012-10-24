package hu.thetree

class Torrents {
	
	String name
	boolean checked = false
	Date uploaded = new Date()
	int downloaded = 0
	long size
	String info_hash
	int seeders = 0
	int leechers = 0
	String description
	
	static belongsTo = [
		category: Category,
		uploader: Users
	]

	static hasMany = [
		comments: TorrentComments
	]

	static mapping = {	
		id generator:'sequence', params:[sequence:'seq_torrent_id']
	}
	
    static constraints = {
		description type:'text', blank: true, nullable: true
    }
}
