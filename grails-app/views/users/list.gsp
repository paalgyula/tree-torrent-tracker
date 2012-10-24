<html>
	<head>
		<title>Felhasználók</title>
		<meta name="layout" content="main">
	</head>
<body>
				<div class="large_window_top">
					<div class="legend"><g:message code="users.list.usersearch" default="Felhasználó kereső"/></div>
				</div>
				<g:each in="${users}" var="user">
				<div class="large_window_bevel">
					<div class="content">
						<tree:userLink user="${user}"/>
					</div>
				</div>
				</g:each>
				<br/><br/>
</body>
</html>