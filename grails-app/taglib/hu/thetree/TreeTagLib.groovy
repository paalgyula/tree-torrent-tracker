package hu.thetree

class TreeTagLib {

	static namespace = "tree"
	
	def springSecurityService
	
	def printUserStats = { attrs, body ->
		def userInstance = Users.findByUsername( springSecurityService.currentUser.username );
		
		out << "${tree.userLink(user: userInstance)} "
		if ( "".equals( userInstance.title ) )
			out << "(${g.message(code: 'user.titles.newbie')}), "
		else
			out << "(${userInstance?.title}), "
		
		out << "Pontok: <a href=\"#\">${userInstance?.points}</a>, "
		out << "Arany: ${tree.ratio(up: userInstance.uploaded, down: userInstance.downloaded)} "
		out << "Fel: ${tree.formatBytes(bytes: userInstance?.uploaded)} Le: ${tree.formatBytes(bytes: userInstance.downloaded)} "
		out << "[<a href=\"#\">Tamogatas</a>]"
	}
	
	def userLink = { attrs, body ->
		def userInstance = Users.findByUsername( springSecurityService.currentUser.username );
		
		def styleClass = attrs.remove( "class" )
		def user = attrs.remove( "user" )
		
		if ( styleClass == null )
			styleClass = ""
		
		out << "<a href=\""
		out << "${g.createLink(controller:'users', action:'view', params:[user: userInstance.username])}"
		out << "\" class=\"${styleClass}\">"
		out << "${userInstance.username}"
		out << "</a>"
	}
	
	def submitBtn = { attrs, body ->
		
	}
	
	/**
	 * byte-okat formaz MB-ra, GB-ra, stb...
	 * @attr bytes REQUIRED a formazando byte-ok
	 */
	def formatBytes = { attrs, body ->
		def bytes = attrs.remove( "bytes" );
		
		if ( !bytes ) {
			out << "0 B";
			return
		}
		
		def metrics = ["B", "KB", "MB", "GB", "TB"]
		def c = 0
		
		while ( ( bytes / 1024 ) > 1 ) {
			c++;
			bytes = bytes/1024;
		}
		
		out << Math.ceil( bytes * 100 ) / 100 << " " << metrics[c]
	}
	
	def ratio = { attrs, body ->
		def up = attrs.remove( "up" )
		def down = attrs.remove( "down" )
		
		down = down == 0 ? 1 : 0;
		up = up == 0 ? 1 : 0;
		
		def ratio = Math.ceil( up / down * 1000 ) / 1000
		def repu = 6		
		
		if ( ratio >= 0.5f )
			repu = 1
		if ( ratio >= 0.6f )
			repu = 2
		if ( ratio >= 0.7f )
			repu = 3
		if ( ratio >= 0.8f )
			repu = 4
		if ( ratio >= 0.9f )
			repu = 5
		if ( ratio >= 1 )
			repu = 6
		if ( ratio > 2 )
			repu = 7
		
		out << "<span class=\"rep" << repu << "\">" << ratio << "</span>"
	}
}
