<html>
<head>
	<title>Torrent kereső</title>
	<meta name="layout" content="main"/>
</head>
<body>
				<br/><br/>
				<div class="large_window_top">
					<div class="legend">Kereső</div>
				</div>
				<div class="large_window_bevel">
					<div class="content">
						<%-- Lapozo --%>
						<div class="pager">
							<g:paginate total="${torrents.size()}"/>
						</div>
						<%-- Lapozo vege --%>
					</div>
				</div>
				<br/><br/>
				
				<div class="large_window_top">
					<div class="legend">
						Torrentek
					</div>
				</div>
				<div class="table">
					<div class="row">
						<div class="cell">
							<div class="caption">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 35px;"><g:sortableColumn title="Típus" property="category.id"/></div>
								<div class="caption-right"></div>
							</div>
						</div>
						<div class="cell">
							<div class="caption">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 414px;">Név</div>
								<div class="caption-right"></div>
							</div>
						</div>
						<div class="cell">
							<div class="caption">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 80px;">Feltöltve</div>
								<div class="caption-right"></div>
							</div>
						</div>
						<div class="cell">
							<div class="caption">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 80px;">Méret</div>
								<div class="caption-right"></div>
							</div>
						</div>
						<div class="cell">
							<div class="caption">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 20px;">D</div>
								<div class="caption-right"></div>
							</div>
						</div>
						<div class="cell">
							<div class="caption">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 20px;">S</div>
								<div class="caption-right"></div>
							</div>
						</div>
						<div class="cell">
							<div class="caption">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 20px;">L</div>
								<div class="caption-right"></div>
							</div>
						</div>
						<div class="cell">
							<div class="caption" style="margin-right: 0px;">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 81px;">Feltöltő</div>
								<div class="caption-right"></div>
							</div>
						</div>
					</div>
				</div>
				
				<g:each in="${torrents}" var="torrent" status="counter">
				<div class="table">
					<%-- a row a tabla egy sora! --%>
					
					<div class="row">
						<div class="torrent_image">
							<img src="images/torrentpics/${torrent.category.imageName}.gif" alt="${torrent.category.name}" title="${torrent.category.name}"/>
						</div>
						<div class="torrent_details">
							<div class="class1<g:if test="counter % 2 == 0">2</g:if>">
								<div class="nev_container">
									<a href="torrentdl.tt?id=${torrent.id}"><img src="images/icons/dl.png" border="0" align="left" title="Torrent letöltése" alt="Torrent letöltése"/></a>
									<a href="#" onclick="$('#detail_${torrent.id}').slideToggle('slow'); return false;">${torrent.name}</a> 
									<br/>&nbsp;
								</div>
								<div class="feltoltve_container">
									${torrent.uploaded}
								</div>
								<div class="meret_container">
									<tree:formatBytes bytes="${torrent.size}"/> 
								</div>
								<div class="dsl_container">
									${torrent.downloaded}
								</div>
								<div class="dsl_container">
									<a href="torrent_details.tt?id={torrent.entry}#peers">${torrent.seeders}</a>
								</div>
								<div class="dsl_container">
									<a href="torrent_details.tt?id={torrent.entry}#peers">${torrent.leechers}</a>
								</div>
								<div class="feltolto_container">
									<a href="${createLink(controller:'users', action: 'view', params:[user: torrent.uploader.username])}">${torrent.uploader.username}</a>
								</div>
							</div>
						</div>
					</div>	
					<%-- Eddig tartott a tablazat! --%>
				</div>
				<div class="torrent_details_content" id="detail_${torrent.id}">
					<div class="content" id="detail_${torrent.id}_content">
						<b>Torrent leirása:</b><br/><br/>
						<g:if test="${torrent.description}">
							${torrent.description}
						</g:if>
						<g:else>
							..:: Nincs leirás ::..
						</g:else>
					</div>
				</div>
				</g:each>			
				
				<br/><br/>
				<div class="large_window_top">
					<div class="legend">Lapozó</div>
				</div>
				<div class="large_window_bevel">
					<div class="content" style="text-align: center; font-weight: bold;">
						<div class="pager">
							<g:paginate total="${torrents.size()}"/>
						</div>
					</div>
				</div>
				<br/><br/>
	</body>
</html>