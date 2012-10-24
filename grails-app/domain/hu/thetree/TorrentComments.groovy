package hu.thetree

class TorrentComments {

	String content
	Date postDate = new Date()
	Date modified
	
	static belongsTo = [
		torrent: Torrents,
		poster: Users
	]
	
	static mapping = {
		version false
	}
	
    static constraints = {
		content blank:false, type: 'text'
		modified nullable: true
    }
}
