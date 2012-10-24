<#include "/inc/head.ftl">
				<br/><br/>
				<div class="large_window_top">
					<div class="legend">Kereső</div>
				</div>
				<div class="large_window_bevel">
					<div class="content">
						Kereső content jön ide...
						<#-- Lapozo -->
						<div class="pager">
						[ 1 ]
						</div>
						<#-- Lapozo vege -->
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
								<div class="caption-bg" style="width: 35px;">Típus</div>
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
				
				<#list torrents as torrent>
				<div class="table">
					<#-- a row a tabla egy sora! -->
					
					<div class="row">
						<div class="torrent_image">
							<img src="images/torrentpics/${torrent.categoryBean.imagename}" alt="${torrent.categoryBean.description!""}" title="${torrent.categoryBean.description!""}"/>
						</div>
						<div class="torrent_details">
							<div class="class1<#if torrent_index % 2 == 0>2</#if>">
								<div class="nev_container">
									<a href="torrentdl.tt?id=${torrent.entry}"><img src="images/icons/dl.png" border="0" align="left" title="Torrent letöltése" alt="Torrent letöltése"/></a>
									<a href="#" onclick="$('#detail_${torrent.entry}').slideToggle('slow'); return false;">${torrent.name}</a> 
									<br/>&nbsp;
								</div>
								<div class="feltoltve_container">
									${torrent.getUploadedFormated()}
								</div>
								<div class="meret_container">
									${torrent.getSizeFormated()}
								</div>
								<div class="dsl_container">
									${torrent.downloaded}
								</div>
								<div class="dsl_container">
									<a href="torrent_details.tt?id=${torrent.entry}#peers">${torrent.seeders}</a>
								</div>
								<div class="dsl_container">
									<a href="torrent_details.tt?id=${torrent.entry}#peers">${torrent.leechers}</a>
								</div>
								<div class="feltolto_container">
									<a href="users.tt?id=1">${torrent.getUser().username}</a>
								</div>
							</div>
						</div>
					</div>	
					<#-- Eddig tartott a tablazat! -->
				</div>
				<div class="torrent_details_content" id="detail_${torrent.entry}">
					<div class="content" id="detail_${torrent.entry}_content">
						<b>Torrent leirása:</b><br/><br/>
						${torrent.description!"..:: Nincs leirás ::.."}
					</div>
				</div>
				</#list>			
				
				<br/><br/>
				<div class="large_window_top">
					<div class="legend">Lapozó</div>
				</div>
				<div class="large_window_bevel">
					<div class="content" style="text-align: center; font-weight: bold;">
						<div class="pager">
							[ 1 ]
						</div>
					</div>
				</div>
				<br/><br/>
<#include "/inc/foot.ftl">