package hu.thetree

class Bugs {

	String title
	String description
	int status = 0 // 0-unreaded, 1-readed, 2-accepted, 3-invalid, 4-fixed/programmed
	
	static belongsTo = [reporter:Users]
	
    static constraints = {
		title blank:false, nullable: false
		description type:'text', blank: false, nullable: false
		status nullable: false, blank: false
		reporter nullable: false
    }
}
