<html>
	<head>
		<title>${torrentsInstance.name}</title>
		<meta name="layout" content="main"/>
	</head>
<body>
				<br/><br/>
				<div class="large_window_top">
					<div class="legend">Torrent részletei</div>
				</div>
				<div class="large_window_bevel">
					<div class="content" style="text-align: center;">
						<h2>${torrentsInstance.name}</h2>
						<a href="torrentdl.tt?id=${torrentsInstance.id}"><img src="${resource(dir:'images/icons', file:'dl.png')}" border="0" title="Torrent letöltése" alt="Torrent letöltése"/></a>
						<br/><br/>
						
						<div class="detailBox">
							<div class="row">
								<div class="label">Torrent mérete:</div><div class="field"><tree:formatBytes bytes="${torrentsInstance.size}"/></div>
							</div>
							<div class="row">
								<div class="label">Feltöltő felhasználó:</div><div class="field"><a href="user_details.tt?id=${torrentsInstance.uploader.id}">${torrentsInstance.uploader.username}</a></div>
							</div>
							<div class="row">
								<div class="label">Feltöltve:</div><div class="field"><g:formatDate date="${torrentsInstance.uploaded}" format="yyyy-MM-dd hh:mm"/></div>
							</div>
							<div class="row">
								<div class="label">Kategória:</div><div class="field">${torrentsInstance.category.name}</div>
							</div>
							<div class="row">
								<div class="label">Letöltve:</div><div class="field">${torrentsInstance.downloaded} alkalommal</div>
							</div>
							<div class="row">
								<div class="label">Leecherek:</div><div class="field">${torrentsInstance.leechers}</div>
							</div>
							<div class="row">
								<div class="label">Seederek:</div><div class="field">${torrentsInstance.seeders}</div>
							</div>
						</div>
					</div>
				</div>
				
				<br/>
				
				<div class="large_window_top">
					<div class="legend"><a name="peers">Torrent peer-ek</a></div>
				</div>
				<div class="table">
					<div class="row">
						<div class="cell">
							<div class="caption">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 120px;">Felhasználó</div>
								<div class="caption-right"></div>
							</div>
						</div>
						<div class="cell">
							<div class="caption">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 120px;">IP cím</div>
								<div class="caption-right"></div>
							</div>
						</div>
						<div class="cell">
							<div class="caption">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 180px;">Letöltve</div>
								<div class="caption-right"></div>
							</div>
						</div>
						<div class="cell">
							<div class="caption">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 100px;">Sebesség<img src="${resource(dir:'images/icons', file:'arrow_down.png')}" align="top" height="13" width="13" alt="Letöltési sebesség" title="Letöltési sebesség"></div>
								<div class="caption-right"></div>
							</div>
						</div>						
						<div class="cell">
							<div class="caption">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 100px;">Sebesség<img src="${resource(dir:'images/icons', file:'arrow_up.png')}" align="top" height="13" width="13" alt="Feltöltési sebesség" title="Feltöltési sebesség"></div>
								<div class="caption-right"></div>
							</div>
						</div>
						<div class="cell">
							<div class="caption">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 100px;">Kliens</div>
								<div class="caption-right"></div>
							</div>
						</div>
						<div class="cell">
							<div class="caption" style="margin: 0px;">
								<div class="caption-left"></div>
								<div class="caption-bg" style="width: 100px;">Frissítve</div>
								<div class="caption-right"></div>
							</div>
						</div>
					</div>
				</div>
				<%-- header vege, peerek kezdete --%>
				<div class="table">
					<#list peers as peer>
						<div class="row">
							<div class="peers_tabla">
								<div class="class1<#if peer_index%2 == 0>2</#if>" style="margin-left: 0px;">
									<div class="peernev">
										<a href="user_details.tt?id={peer.user.userid}">{peer.user.username}</a>
									</div>
									<div class="ip">
										{peer.ip}
									</div>
									<div class="letoltve">
										{peer.getDownloadedPercent()}%
									</div>
									<div class="speed">
										{peer.getDownspeedFormated()}
									</div>
									<div class="speed">
										{peer.getUpspeedFormated()}
									</div>
									<div class="kliens">
										RTorrent<br/>
										<small>(fake/static)</small>
									</div>
									<div class="frissitve">
										{peer.getHeartbeatFormated()}
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="torrent_separator"></div>
						</div>
					</#list>
				</div>
				<br/><br/>
</body>
</html>