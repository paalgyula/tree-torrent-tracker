<html>
<head>
	<meta name="layout" content="main">
	 <title>Bugreport</title>
</head>
<body>
	<br/><br/>
	<div class="large_window_top">
		<div class="legend">
			Hiba bejelentése
		</div>
	</div>
	<div class="large_window_bevel">
		<div class="content">
			<g:form method="post" name="bugform">
				<div class="detailBox">
					<div class="row">
						<div class="label">Bejelentő felhasználó: </div>
						<div class="field"><tree:userLink/></div>
					</div>
					<div class="row">
						<div class="label">Hiba/javaslat megnevezése: </div>
						<div class="field"><input type="text" name="title" value="${fieldValue(bean: bugsInstance, field: 'title')}" class="${hasErrors(bean: bugsInstance, field: 'title', 'error')}"></div>
					</div>
					<div class="row">
						<div class="label" style="vertical-align: top;">Hiba/javaslat részletes leirása: </div>
						<div class="field"><textarea name="description" class="${hasErrors(bean: bugsInstance, field: 'description', 'error')}">${fieldValue(bean: bugsInstance, field: 'description')}</textarea></div>
					</div>
					<div class="row">
						<div class="label">&nbsp;</div>
						<div class="field">
						<g:hasErrors bean="${bugsInstance}">
							<span class="errorstring">
								<g:renderErrors bean="${bugsInstance}" as="list"/>
							</span>
						</g:hasErrors>
						</div>
					</div>
					<div class="row">
						<div class="label">&nbsp;</div>
						<div class="field">
							<div class="button" onclick="$('#bugform').submit();">
								<div class="button-left"></div>
								<div class="content">bejelentés</div>
								<div class="button-right"></div>
							</div>
						</div>
					</div>
				</div>
			</g:form>
		</div>
	</div>
	
	<br/>
	
	<div class="large_window_top">
		<div class="legend">
			Bugok:
		</div>
	</div>
	<div class="table">
		<div class="row">
			<div class="cell">
				<div class="caption">
					<div class="caption-left"></div>
					<div class="caption-bg" style="width: 35px;">Státusz</div>
					<div class="caption-right"></div>
				</div>
			</div>
			<div class="cell">
				<div class="caption">
					<div class="caption-left"></div>
					<div class="caption-bg">Megnevezés</div>
					<div class="caption-right"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>