package hu.thetree

class News {

	String title
	String htmlContent
	Date uploaded = new Date()
	Users uploader
	
    static constraints = {
		title blank: false
		uploader blank: false, nullable: false
		htmlContent type: 'text'
    }
}
