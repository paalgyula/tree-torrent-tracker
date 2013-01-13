<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="large_window_top">
    <div class="legend">Belépés</div>
</div>
<div class="large_window_bevel">
    <div class="content">
        <br/><br/>
        <spring:url var="loginAction" value="/check_login"/>
        <form method="post" action="${loginAction}" id="loginForm">
            <div id="loginBox">
                <div class="row">
                    <div class="label"></div>
                    <div class="field">
                        <img src="<spring:url value="/images/vizjel.png"/>" alt="TheTree&trade;"
                             title="TheTree&trade;"/>
                    </div>
                </div>
                <div class="row">
                    <div class="label">Felhasználónév:</div>
                    <div class="field"><input type="text" name="j_username"/></div>
                </div>
                <div class="row">
                    <div class="label">Jelszó:</div>
                    <div class="field"><input type="password" name="j_password"/></div>
                </div>
                <div class="row">
                    <div class="label">Maradjon bejelentkezve:</div>
                    <div class="field"><input type="checkbox" name="j_remember_me"/></div>
                </div>
                <div class="row">
                    <div class="label">&nbsp;</div>
                    <div class="field"><span class="errorstring">${hibauzenet}</span></div>
                </div>
                <div class="row">
                    <div class="label" style="text-align:right">
                        <input type="submit" style="visibility: hidden" id="submitBtn"/>
                    </div>
                    <div class="field">
                        <div class="button" onclick="document.getElementById('submitBtn').click();">
                            <div class="button-left"></div>
                            <div class="content">belépés</div>
                            <div class="button-right"></div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <br/><br/>
    </div>
</div>