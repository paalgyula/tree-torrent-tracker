package hu.thetree

import org.apache.commons.lang.builder.HashCodeBuilder

class UsersRoles implements Serializable {

	Users users
	Roles roles

	boolean equals(other) {
		if (!(other instanceof UsersRoles)) {
			return false
		}

		other.users?.id == users?.id &&
			other.roles?.id == roles?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (users) builder.append(users.id)
		if (roles) builder.append(roles.id)
		builder.toHashCode()
	}

	static UsersRoles get(long usersId, long rolesId) {
		find 'from UsersRoles where users.id=:usersId and roles.id=:rolesId',
			[usersId: usersId, rolesId: rolesId]
	}

	static UsersRoles create(Users users, Roles roles, boolean flush = false) {
		new UsersRoles(users: users, roles: roles).save(flush: flush, insert: true)
	}

	static boolean remove(Users users, Roles roles, boolean flush = false) {
		UsersRoles instance = UsersRoles.findByUsersAndRoles(users, roles)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(Users users) {
		executeUpdate 'DELETE FROM UsersRoles WHERE users=:users', [users: users]
	}

	static void removeAll(Roles roles) {
		executeUpdate 'DELETE FROM UsersRoles WHERE roles=:roles', [roles: roles]
	}

	static mapping = {
		id composite: ['roles', 'users']
		version false
	}
}
