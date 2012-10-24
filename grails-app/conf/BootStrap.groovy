import hu.thetree.Category
import hu.thetree.Roles
import hu.thetree.Users
import hu.thetree.UsersRoles;

class BootStrap {

    def init = { servletContext ->
		if ( !Category.list() ) {
			new Category( name: "Film (HUN XviD)", imageName: "xvidhun" ).save(flush: true)
			new Category( name: "Film (ENG XviD)", imageName: "xvid" ).save(flush: true)
			new Category( name: "Film (HUN DVD)", imageName: "dvdhun" ).save(flush: true)
			new Category( name: "Film (ENG DVD)", imageName: "dvd" ).save(flush: true)
			new Category( name: "Film (HUN DVD9)", imageName: "dvd9hun" ).save(flush: true)
			new Category( name: "Film (ENG DVD9)", imageName: "dvd9" ).save(flush: true)
			new Category( name: "Film (HUN HD)", imageName: "hdhun" ).save(flush: true)
			new Category( name: "Film (ENG HD)", imageName: "hd" ).save(flush: true)
			new Category( name: "Sorozat (HUN XviD)", imageName: "seriesxvidhun" ).save(flush: true)
			new Category( name: "Sorozat (ENG XviD)", imageName: "seriesxvid" ).save(flush: true)
			new Category( name: "Sorozat (HUN DVD)", imageName: "seriesdvdhun" ).save(flush: true)
			new Category( name: "Sorozat (ENG DVD)", imageName: "seriesdvd" ).save(flush: true)
			new Category( name: "Sorozat (HUN HD)", imageName: "serieshdhun" ).save(flush: true)
			new Category( name: "Sorozat (ENG HD)", imageName: "serieshd" ).save(flush: true)
			new Category( name: "Mp3 (HUN)", imageName: "mp3hun" ).save(flush: true)
			new Category( name: "Mp3 (ENG)", imageName: "mp3" ).save(flush: true)
			new Category( name: "Lossless (HUN)", imageName: "flachun" ).save(flush: true)
			new Category( name: "Lossless (ENG)", imageName: "flac" ).save(flush: true)
			new Category( name: "Klip", imageName: "" ).save(flush: true)
			new Category( name: "Játék (ISO)", imageName: "gameiso" ).save(flush: true)
			new Category( name: "Játék (RIP)", imageName: "gamerip" ).save(flush: true)
			new Category( name: "Program (ISO)", imageName: "iso" ).save(flush: true)
			new Category( name: "Program", imageName: "misc" ).save(flush: true)
			new Category( name: "XXX (XviD)", imageName: "xxxxvid" ).save(flush: true)
			new Category( name: "XXX (DVD/DVD9)", imageName: "xxxdvd9" ).save(flush: true)
			new Category( name: "XXX (Imageset)", imageName: "xxximageset" ).save(flush: true)
			new Category( name: "XXX (HD)", imageName: "xxxhd" ).save(flush: true)
		}
		
		if ( !Users.list() )
			new Users(
				username: "goofyx",
				password: "0027462",
				email: "paalgyula@gmail.com",
				enabled: true,
				accountExpired: false,
				accountLocked: false,
				passwordExpired: false
			).save( flush: true )
			
		if ( !Roles.list() ) 
			new Roles( authority: "ROLE_USER" ).save( flush: true )
			
		if ( !UsersRoles.list() )
			new UsersRoles( users: Users.findByUsername( "goofyx" ), roles: Roles.findByAuthority( "ROLE_USER" ) ).save( flush: true );
		
    }
	
    def destroy = {
    }
}
