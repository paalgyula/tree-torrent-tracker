<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="robots" content="none noindex nofollow" />
    <meta name="author" content="Paál Gyula (goofy) [http://www.gw-systems.com/munkatarsak/goofy]" />
    <meta name="copyright" content="2011, GW-Systems Kft." />
    <meta name="description" content="TheTree torrent tracker" />
    <title>TheTree™ - <g:layoutTitle default="The MW Tracker"/></title>
    <link rel="icon" href="${resource(file:'favicon.ico')}" type="image/x-icon" />
    <link rel="shortcut icon" href="${resource(file:'favicon.ico')}" type="image/x-icon" />
    <link rel="stylesheet" media="screen" href="${resource(dir:'css', file:'main.css')}" />
    <script type="text/javascript" src="${resource(dir:'js',file:'jquery.min.js')}"></script>
    <g:layoutHead />
</head>
<body>
<div id="main_background">
	<div id="main_placeholder">
		<div id="content">
			<div class="decor_blue"></div>
			<div class="decor_separator"></div>
			<div id="header"></div>
			<div class="decor_separator"></div>
			<div class="menu">
				<div class="left"></div>
				<div class="bg">
						<sec:ifNotLoggedIn>
							<g:link controller="index" class="nyilas_hivatkozas">Belépés</g:link>
							<g:link controller="index" action="register" class="nyilas_hivatkozas">Regisztráció</g:link>
						</sec:ifNotLoggedIn>
						<sec:ifLoggedIn>
							<g:link controller="index" class="nyilas_hivatkozas">Főoldal</g:link>
							<g:link controller="torrents" action="list" class="nyilas_hivatkozas">Letöltés</g:link>
							<g:link controller="torrents" action="upload" class="nyilas_hivatkozas">Feltöltés</g:link>
							<g:link controller="index" class="nyilas_hivatkozas">Kérések</g:link>
							<g:link controller="index" class="nyilas_hivatkozas">Top10</g:link>
							<g:link controller="index" class="nyilas_hivatkozas">Fórum</g:link>
							<g:link controller="index" class="nyilas_hivatkozas">Wiki</g:link>
							<g:link controller="users" action="list" class="nyilas_hivatkozas">Felhasználók</g:link>
							<g:link controller="bug" action="index" class="nyilas_hivatkozas purple">Bugreport</g:link>
							<g:link controller="index" action="logout" class="nyilas_hivatkozas">Kilépés</g:link>
						</sec:ifLoggedIn>
				</div>
				<div class="right"></div>
			</div>
			<div class="decor_separator"></div>
			<sec:ifLoggedIn>
			<div id="usercontrol">
				<div class="left">
					<tree:printUserStats/> 
				</div>
			</div>
			</sec:ifLoggedIn>
			<div class="decor_blue"></div>
			<div id="topBg">
				<br/><br/>
        		<g:layoutBody />
        	</div>
			<div id="bg_placeholder"></div>
		</div>
		<div id="footer">
			<div class="decor_separator"></div>
			<div class="menu">
				<div class="left"></div>
				<div class="bg"><small>TheTree&trade; Torrent tracker r<i>152</i> | Hosted &amp; Powered: GW-Systems</small></div>
				<div class="right"></div>
			</div>
			<div class="decor_separator"></div>
			<div class="decor_blue"></div>
		</div>
	</div>
</div>
</body>
</html>