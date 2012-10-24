package hu.thetree

import grails.plugins.springsecurity.SpringSecurityService;

class IndexController {

	def springSecurityService
	
	static allowedMethods = [register:['GET', 'POST']]
	
    def index = {
		if ( params.login_error != null ) {
			render view: "/login", model:[hibauzenet: "${g.message(code: 'login.failed')}"]
			return
		}
		
		if  ( !springSecurityService.isLoggedIn() ) {
			render view: "/login"
			return
		}
		
		def news = News.createCriteria().list {
			order( "uploaded", "desc" )
			maxResults(10)
		}
		
		Users userInstance = Users.findByUsername( springSecurityService.currentUser.username )
		render view: "/index", model: [
			news: news,
			treeUser: userInstance
		]
	}
	
	def logout = {
		session.invalidate()
		redirect controller: 'index'
	}
	
	def register = {
		if ( params.status != null ) {
			render view: '/register/success'
			return
		}
		
		if ( request.method == 'POST' ) {
			def errorStr = "";
			if ( !params.treePass1.equals( params.treePass2 ) )
				errorStr += "${g.message(code: 'register.passnotmatch')}<br/>"
			else if ( params.treePass1.length() < 5 )
				errorStr += "${g.message(code: 'register.passwordtooshort')}<br/>"
			if ( !params.treeEmail1.equals( params.treeEmail2 ) )
				errorStr += "${g.message(code: 'register.emailnotmatch')}<br/>"
			else if ( !(params.treeEmail1 ==~ /[a-zA-Z0-9._+-]+@[a-zA-Z0-9.-]+\.[A-Za-z]{2,4}/) )
				errorStr += "${g.message(code: 'register.emailnotvalid')}<br/>"
			if ( params.treeUser.length() < 3 )
				errorStr += "${g.message(code: 'register.usernametooshort')}<br/>"
			if ( params.past13 != "on" )
				errorStr += "${g.message(code: 'register.notpermitunder13')}<br/>"
			if ( params.agreeTerms != "on" )
				errorStr += "${g.message(code: 'register.accepttermsbeforeregister')}<br/>"
			if ( Users.findByUsername( params.treeUser ) != null )
				errorStr += "${g.message(code: 'register.useralreadyexist')}"
			
			if ( errorStr == "" ) {
				def userInstance = new Users(
					username: params.treeUser,
					password: params.treePass1,
					email: params.treeEmail1,
					enabled: true,
					registred: new Date()
				)
				
				userInstance.save( flush: true )
				redirect controller:"index", action: "register", params: [status: "success"]
				return
			}
									
			render view:"/register/register", model: [hibauzenet: errorStr, params: params ]
		} else 
			render view: "/register/register"
	}
}
