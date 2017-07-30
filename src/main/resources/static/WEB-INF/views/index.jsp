<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <title>Belépés</title>
    </head>
    	<body>
				<div class="large_window_top">
					<div class="legend">Hírek/Újdonságok</div>
				</div>
				<g:each in="${news}" var="newsItem">
				<div class="large_window_bevel">
					<div class="content">
						<img src="images/vizjel.png" alt="" title="" align="right"/>
						<h3>${newsItem.title}</h3>
						<br/>
						${newsItem.htmlcontent}
						<br/>
						<p align="right">
							${newsItem.uploaded}<br/>
							<b>${newsItem.uploader.username}</b>
						</p>
					</div>
				</div>
				</g:each>
				<br/><br/>
</body>
</html>