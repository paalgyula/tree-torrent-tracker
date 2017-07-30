<#include "/inc/head.ftl">
				<br/><br/>
				<div class="large_window_top">
					<div class="legend">Visszajelzés</div>
				</div>
				<div class="large_window_bevel">
					<div class="content">
						<br/><br/>
							<div id="loginBox">
								<div class="row">
									<div class="label"></div>
									<div class="field">
										<img src="images/torrentpics/${torrent.categoryBean.imagename}" alt="${torrent.categoryBean.description}" title="${torrent.categoryBean.description}" align="left"/>
										<h2>&nbsp;&nbsp;Torrent sikeresen feltöltve!</h2>
									</div>
								</div>
								<div class="row">
									<div class="label">Torrent azonosító:</div>
									<div class="field"><input type="text" value="${torrent.entry}" readonly="readonly"/></div>
								</div>
								<div class="row">
									<div class="label">Torrent neve:</div>
									<div class="field"><input type="text" value="${torrent.name}" readonly="readonly"/></div>
								</div>
								<div class="row">
									<div class="label">Torrent hash:</div>
									<div class="field"><input type="text" value="${torrent.info_hash}" readonly="readonly"/></div>
								</div>
								<div class="row">
									<div class="label">Kategória:</div>
									<div class="field"><input type="text" value="${torrent.categoryBean.title}" readonly="readonly"/></div>
								</div>
								<div class="row">
									<div class="label">Méret:</div>
									<div class="field"><input type="text" value="${torrent.getSizeFormated()}" readonly="readonly"/></div>
								</div>
								<div class="row">
									<div class="label">Feltöltve:</div>
									<div class="field"><input type="text" value="${torrent.getUploadedFormated()}" readonly="readonly"/></div>
								</div>
								<div class="row">
									<div class="label">Feltöltő:</div>
									<div class="field"><input type="text" value="${torrent.user.username}" readonly="readonly"/></div>
								</div>
								<div class="row">
									<div class="label">&nbsp;</div>
									<div class="field">&nbsp;</div>
								</div>
								<div class="row">
									<div class="label">&nbsp;</div>
									<div class="field">
										<input type="submit" style="display: none"/>
										<div class="button" onclick="window.location.href='kereso.tt'">
											<div class="button-left"></div>
											<div class="content">Vissza a keresőhöz</div>
											<div class="button-right"></div>
										</div>
									</div>
								</div>
							</div>
						<br/><br/>
					</div>
				</div>
<#include "/inc/foot.ftl">