package hu.thetree

class Category {

	String name
	String imageName
	
	static hasMany = [torrents:Torrents]
	
	static mapping = {
		version false
	}
	
    static constraints = {
		name nullable: false, blank: false
    }
}
