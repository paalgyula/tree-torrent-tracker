<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="robots" content="none noindex nofollow" />
    <meta name="author" content="Paál Gyula (goofy) [http://www.gw-systems.com/munkatarsak/goofy]" />
    <meta name="copyright" content="2011, GW-Systems Kft." />
    <meta name="description" content="TheTree torrent tracker" />
    <title>TheTree™ - <tiles:getAsString name="title" ignore="true"/></title>
    <spring:url var="faviconUrl" value="/favicon.ico" />
    <spring:url var="mainCss" value="/css/main.css"/>
    <spring:url var="jqueryUrl" value="/js/jquery.min.js"/>
    <link rel="icon" href="${faviconUrl}" type="image/x-icon" />
    <link rel="shortcut icon" href="${faviconUrl}" type="image/x-icon" />
    <link rel="stylesheet" media="screen" href="${mainCss}" />
    <script type="text/javascript" src="${jqueryUrl}"></script>
    <tiles:insertAttribute name="customHeader" ignore="true"/>
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
						<sec:authorize access="isAnonymous()">
							<a href="<spring:url value="/Login"/>" class="nyilas_hivatkozas">Belépés</a>
							<a href="<spring:url value="/Register"/>" class="nyilas_hivatkozas">Regisztráció</a>
						</sec:authorize>
						<sec:authorize access="isAuthenticated()">
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
						</sec:authorize>
				</div>
				<div class="right"></div>
			</div>
			<div class="decor_separator"></div>
            <sec:authorize access="isAuthenticated()">
			<div id="usercontrol">
				<div class="left">
					<tree:printUserStats/> 
				</div>
			</div>
			</sec:authorize>
			<div class="decor_blue"></div>
			<div id="topBg">
				<br/><br/>
                <tiles:insertAttribute name="body"/>
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