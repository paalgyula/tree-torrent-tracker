class UrlMappings {

    static mappings = {
        /*"/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }*/


        "/"(controller: "index")

        "/User/${user}.tt"(controller: "users", action: "view")
        "/User"(controller: "users", action: "list")

        "/Torrent"(controller: "torrents", action: "list")
        "/Torrent/Search"(controller: "torrents", action: "search")
        "/Torrent/Upload"(controller: "torrents", action: "upload")
        "/Torrent/$id/$name?"(controller: "torrents", action: "show")

        "/Logout.tt"(controller: "index", action: "logout")
        "/index.tt"(controller: "index", action: "index")
        "/Register.tt"(controller: "index", action: "register")
        "/doregister.tt"(controller: "index", action: "doregister")

        "/Bugs"(controller: "bug")
        "/Bugs/Success"(controller: "bug", action: "success")

        "500"(view: '/error')
    }
}
