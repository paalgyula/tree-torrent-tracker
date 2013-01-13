<html>
	<head>
		<title>Torrent feltöltés</title>
		<meta name="layout" content="main">
	</head>
<body>
			<br/><br/>
				<div class="large_window_top">
					<div class="legend">Torrent feltöltése</div>
				</div>
				<div class="large_window_bevel">
					<div class="content">
						<br/><br/>
						<g:uploadForm method="post" action="upload" name="uploadForm" useToken="true" >
							<div id="loginBox">
								<div class="row">
									<div class="label"></div>
									<div class="field">
										<b>Torrent feltöltése</b>
									</div>
								</div>
								<div class="row">
									<div class="label">Kategória:</div>
									<div class="field">
										<g:select from="${categories}" optionKey="id" optionValue="name" name="category.id" value="${fieldValue(bean: torrentsInstance, field: 'category.id')}"/>
									</div>
								</div>
								<div class="row">
									<div class="label">Torrent neve:</div>
									<div class="field"><input type="text" name="name" value="${fieldValue(bean: torrentsInstance, field: 'name')}"/></div>
								</div>
								<div class="row">
									<div class="label" style="vertical-align: top;">Torrent leirása:</div>
									<div class="field"><textarea name="description">${fieldValue(bean: torrentsInstance, field: 'description')}</textarea></div>
								</div>
								<div class="row">
									<div class="label">Torrent file:</div>
									<div class="field"><input type="file" name="file"/></div>
								</div>
								<div class="row">
									<div class="label">
										<g:hasErrors bean="${torrentsInstance}">
											<g:renderErrors bean="${torrentsInstance}" as="list"/>
										</g:hasErrors>
									</div>
									<div class="field"><tree:formatBytes bytes="${torrentsInstance?.size}"/></div>
								</div>
								<div class="row">
									<div class="label">&nbsp;</div>
									<div class="field">
										<input type="submit" style="display: none"/>
										<div class="button" onclick="$('#uploadForm').submit();">
											<div class="button-left"></div>
											<div class="content">Torrent feltöltése</div>
											<div class="button-right"></div>
										</div>
									</div>
								</div>
							</div>
						</g:uploadForm>
						<br/><br/>
					</div>
				</div>
</body>
</html>