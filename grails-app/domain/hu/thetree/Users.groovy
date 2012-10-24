package hu.thetree

import java.util.Date;

class Users {

	transient springSecurityService

	String username
	String password
	String email
	Date registred = new Date()
	Date lastlogin
	
	int points = 0
	long uploaded = 0L
	long downloaded = 0L
	String title = "Újonc"
	
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static hasMany = [news: News]

	static constraints = {
		email email: true
		username blank: false, unique: true
		password blank: false
		lastlogin nullable: true, blank: true
		title blank: true
	}

	static mapping = {
		password column: '`password`'
		version false
		id generator:'sequence', params:[sequence:'seq_users_id']
	}

	Set<Roles> getAuthorities() {
		UsersRoles.findAllByUsers(this).collect { it.roles } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
