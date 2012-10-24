<html>
<head>
    <meta name="layout" content="main" />
</head>
<body>
				<div class="large_window_top">
					<div class="legend">Regisztráció</div>
				</div>
				<div class="large_window_bevel">
					<div class="content">
						<br/><br/>
						<g:form controller="index" action="register" method="post" id="registerForm" useToken="true">
							<div id="loginBox">
								<div class="row">
									<div class="label"></div>
									<div class="field"><img src="${request.contextPath}/images/vizjel.png" alt="TheTree&trade;" title="TheTree&trade;"/></div>
								</div>
								<div class="row">
									<div class="label">Felhasználónév:</div>
									<div class="field"><input type="text" name="treeUser" value="${params.treeUser}"/></div>
								</div>
								<div class="row">
									<div class="label">Jelszó:</div>
									<div class="field"><input type="password" name="treePass1"/></div>
								</div>
								<div class="row">
									<div class="label">Jelszó megismételve:</div>
									<div class="field"><input type="password" name="treePass2"/></div>
								</div>
								<div class="row">
									<div class="label">E-Mail cím:</div>
									<div class="field"><input type="text" name="treeEmail1" value="${params.treeEmail1}"/></div>
								</div>
								<div class="row">
									<div class="label">E-Mail cím megismételve:</div>
									<div class="field"><input type="text" name="treeEmail2" value="${params.treeEmail2}"/></div>
								</div>
								<div class="row">
									<div class="label">Neme:</div>
									<div class="field">
										<select name="treeSex">
											<option value="0" selected="selected">Férfi</option>
											<option value="1">Nő</option>
										</select>
									</div>
								</div>
								
								
								<div class="row">
									<div class="label">&nbsp;</div>
									<div class="field"><span class="errorstring">${hibauzenet}</span></div>
								</div>
								<div class="row">
									<div class="label">Elmúltam 13 éves:</div>
									<div class="field"><input type="checkbox" name="past13"/></div>
								</div>
								<div class="row">
									<div class="label">Elfogadom a felhasználási feltételeket:</div>
									<div class="field"><input type="checkbox" name="agreeTerms"/></div>
								</div>
								<div class="row">
									<div class="label">&nbsp;</div>
									<div class="field">
										<input type="submit" style="display: none" id="btn"/>
										<div class="button" onclick="document.getElementById('btn').click();">
											<div class="button-left"></div>
											<div class="content">regisztráció</div>
											<div class="button-right"></div>
										</div>
									</div>
								</div>
							</div>
						</g:form>
						<br/><br/>
					</div>
				</div>
</body>
</html>