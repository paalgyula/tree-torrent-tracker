package hu.thetree

import hu.thetree.tools.Bencode;

class TorrentsController {

	def currentUserService
	def springSecurityService
	
    def list = {
		render view: "list", model: [torrents: Torrents.list( limit: 50 )]
	}
	
	def search = {
		
	}

	def upload = {
		if ( request.method == "GET" ) {
			render view: "upload_step1", model: [categories: Category.list()]
		} else {
			def size = 0;
			def decodedTorrent = Bencode.decode( params.file.inputStream.text )
			
			def torrentContent = [:]
			torrentContent.name = decodedTorrent.info.name
			torrentContent.info = [:]
			torrentContent.info["piece length"] = decodedTorrent.info["piece length"]
			torrentContent.info.pieces = decodedTorrent.info.pieces
			
			if ( decodedTorrent.info.length ) 
				size = decodedTorrent.info.length
			else
				decodedTorrent.info.files.each {
					size += it.length
				}
				
			def torrentsInstance = new Torrents(params)
			torrentsInstance.uploader = currentUserService.getCurrentUser()
			torrentsInstance.info_hash = torrentContent.info.toString().encodeAsMD5()
			torrentsInstance.size = size;
			
			if ( torrentsInstance.save() ) {
				def file = new File("/home/torrent/${torrentsInstance.id}.torrent")
				redirect action: "show", params:[id: torrentsInstance.id, name: torrentsInstance.name]
				return
			}
						
			render view: "upload_step1", model: [categories: Category.list(), torrentsInstance: torrentsInstance]
		}
	}
	
	
	def show = {
		def torrentsInstance = Torrents.get( params.id )
		render view: "show", model: [torrentsInstance: torrentsInstance]
	}
}
