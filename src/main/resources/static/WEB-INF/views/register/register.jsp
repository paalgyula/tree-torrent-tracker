<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="large_window_top">
    <div class="legend">Regisztráció</div>
</div>
<div class="large_window_bevel">
    <div class="content">
        <br/><br/>
        <form:form method="post" id="registerForm" useToken="true" commandName="user">
            <div id="loginBox">
                <div class="row">
                    <div class="label"></div>
                    <div class="field"><img src="<spring:url value="/images/vizjel.png"/>" alt="TheTree&trade;" title="TheTree&trade;"/></div>
                </div>
                <div class="row">
                    <div class="label">
                        <form:label path="username">Felhasználónév:</form:label>
                    </div>
                    <div class="field">
                        <form:input path="username" type="text"/>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <form:label path="password">Jelszó:</form:label>
                    </div>
                    <div class="field">
                        <form:password path="password"/>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <form:label path="password2">Jelszó megismételve:</form:label>
                    </div>
                    <div class="field">
                        <form:password path="password2"/>
                    </div>
                </div>
                <div class="row">
                    <div class="label">
                        <form:label path="email">E-Mail cím:</form:label>
                    </div>
                    <div class="field">
                        <form:input path="email"/>
                    </div>
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
                    <div class="field">
                        <span class="errorstring">
                            <form:errors path="*" cssClass="errorstring" element="span"/>
                        ${hibauzenet}
                        </span>
                    </div>
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
        </form:form>
        <br/><br/>
    </div>
</div>