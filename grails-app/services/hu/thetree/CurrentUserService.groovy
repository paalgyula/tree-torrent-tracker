package hu.thetree

class CurrentUserService {

    static transactional = true
	static scope = "session"

    def springSecurityService
	
	def getCurrentUser = {
		return Users.findByUsername( springSecurityService.authentication.principal.username )
	}
}
