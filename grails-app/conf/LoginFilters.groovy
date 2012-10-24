

class LoginFilters {

	def springSecurityService
	
	def filters = {
		loginCheck(controller:'*', action:'*') {
			before = {
				if(!springSecurityService.isLoggedIn() && !controllerName.equals("index") ) {
					redirect(controller: 'index')
					return false
				}
			}
		}
	}
}
