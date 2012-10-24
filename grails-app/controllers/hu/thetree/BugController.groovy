package hu.thetree

import grails.plugins.springsecurity.Secured;

@Secured("ROLE_USER")
class BugController {

	def springSecurityService
	
    def index = {
		if (request.method == "POST") {
			def bugsInstance = new Bugs( params )
			bugsInstance.reporter = Users.findByUsername( springSecurityService.currentUser.username )
			withForm {
				if ( bugsInstance.save() ) {
					render view: "success"
				} else {
					render view: "index", model:[bugsInstance: bugsInstance, bugsList: Bugs.list()]
				}
			}.invalidToken {
				render view: "index", model:[bugsInstance: bugsInstance, bugsList: Bugs.list()]
			}
		} else
			render view: "index", model:[bugsList: Bugs.list()]
	}
	
}
