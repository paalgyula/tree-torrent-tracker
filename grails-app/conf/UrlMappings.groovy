class UrlMappings {

	static mappings = {
		/*"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}*/
		
		
		"/"(controller:"index")
		
		"/Users/${user}.tt"(controller:"users", action: "view")
		"/Users"(controller:"users", action: "list")
		
		"/Torrents"(controller:"torrents", action: "list")
		"/Torrents/Search"(controller:"torrents", action:"search")
		"/Torrents/Upload"(controller:"torrents", action:"upload")
		"/Torrents/$id/$name?"(controller:"torrents", action:"show")
		
		"/Logout.tt"(controller:"index", action: "logout")
		"/index.tt"(controller:"index", action: "index")
		"/Register.tt"(controller:"index", action: "register")
		"/doregister.tt"(controller:"index", action: "doregister")
		
		"/Bugs"(controller: "bug")
		"/Bugs/Success"(controller: "bug", action: "success")
		
		"500"(view:'/error')
	}
}
