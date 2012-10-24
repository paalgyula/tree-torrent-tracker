package hu.thetree

import grails.converters.JSON;

class UsersController {

	def springSecurityService
	
    def index = {
		redirect action:'list'
	}
	
	def view = {
		log.fatal params.user
		
		if ( params.user == springSecurityService.currentUser.username ) {
			render "SELFMADE!!!!!!!!!!!"
			return
		}
		
		def userInstance = Users.findByUsername( params.user )
		if ( userInstance == null ) {
			render "nincs ilyen felhasznalo!"
			return;
		}
		
		render ([username: params.user] as JSON)
	}
	
	def list = {
		render view:'list', model: [users: Users.list(limit: 10)]
	}
}
