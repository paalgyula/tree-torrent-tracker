<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tt" uri="http://paalgyula.hu/thetree" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<br/><br/>

<div class="large_window_top">
    <div class="legend">Kereső</div>
</div>
<div class="large_window_bevel">
    <div class="content">
        <%-- Lapozo --%>
        <div class="pager">
            <g:paginate total="$ {torrents.size()}"/>
        </div>
        <%-- Lapozo vege --%>
    </div>
</div>
<br/><br/>

<div class="large_window_top">
    <div class="legend">
        Torrentek
    </div>
</div>

<table class="table">
    <tr class="row">
        <td class="cell caption">
            <div class="caption-left"></div>
            <div class="caption-bg" style="width: 35px;">Típus</div>
            <div class="caption-right"></div>
        </td>
        <td class="cell caption">
            <div class="caption-left"></div>
            <div class="caption-bg" style="width: 412px">Név</div>
            <div class="caption-right"></div>
        </td>
        <td class="cell caption">
            <div class="caption-left"></div>
            <div class="caption-bg" style="width: 80px;">Feltöltve</div>
            <div class="caption-right"></div>
        </td>
        <td class="cell caption">
            <div class="caption-left"></div>
            <div class="caption-bg" style="width: 80px;">Méret</div>
            <div class="caption-right"></div>
        </td>
        <td class="cell caption">
            <div class="caption-left"></div>
            <div class="caption-bg" style="width: 20px;">D</div>
            <div class="caption-right"></div>
        </td>
        <td class="cell caption">
            <div class="caption-left"></div>
            <div class="caption-bg" style="width: 20px;">S</div>
            <div class="caption-right"></div>
        </td>
        <td class="cell caption">
            <div class="caption-left"></div>
            <div class="caption-bg" style="width: 20px;">L</div>
            <div class="caption-right"></div>
        </td>
        <td class="cell caption">
            <div class="caption-left"></div>
            <div class="caption-bg" style="width: 81px;">Feltöltő</div>
            <div class="caption-right"></div>
        </td>
    </tr>


    <c:forEach items="${torrents}" var="torrent" varStatus="stat">
        <c:choose>
            <c:when test="${stat.index % 2 == 0}">
                <c:set var="oiClass" value="odd"/>
            </c:when>
            <c:otherwise>
                <c:set var="oiClass" value="even"/>
            </c:otherwise>
        </c:choose>
        <tr class="row ${oiClass}">
            <td class="cell caption">
                <spring:url var="tImage" value="/images/torrentpics/{image}.gif">
                    <spring:param name="image" value="${torrent.category.image}"/>
                </spring:url>
                <img src="${tImage}" style="margin-bottom: -2px;"
                     alt="${torrent.category.category}"
                     title="${torrent.category.category}"/>
            </td>
            <td class="cell caption">
                    ${torrent.name}
            </td>
            <td class="cell caption c">
                <fmt:formatDate value="${torrent.uploaded}" pattern="yyyy-MM-dd"/>
                <br/>
                <fmt:formatDate value="${torrent.uploaded}" pattern="HH:ss"/>
            </td>
            <td class="cell caption c">
                    ${tt:formatBytes(torrent.size)}
            </td>
            <td class="cell caption c">
                    ${torrent.downloaded}
            </td>
            <td class="cell caption c">
                    ${torrent.seeders}
            </td>
            <td class="cell caption c">
                    ${torrent.leechers}
            </td>
            <td class="cell caption c">
                    ${torrent.uploader.username}
            </td>
        </tr>
    </c:forEach>
</table>

<%--
<g:each in="${torrents}" var="torrent" status="counter">
<div class="table">
    <div class="row">
        <div class="torrent_image">
            <img src="images/torrentpics/${torrent.category.imageName}.gif" alt="${torrent.category.name}" title="${torrent.category.name}"/>
        </div>
        <div class="torrent_details">
            <div class="class1<g:if test="counter % 2 == 0">2</g:if>">
                <div class="nev_container">
                    <a href="torrentdl.tt?id=${torrent.id}"><img src="images/icons/dl.png" border="0" align="left" title="Torrent letöltése" alt="Torrent letöltése"/></a>
                    <a href="#" onclick="$('#detail_${torrent.id}').slideToggle('slow'); return false;">${torrent.name}</a>
                    <br/>&nbsp;
                </div>
                <div class="feltoltve_container">
                    ${torrent.uploaded}
                </div>
                <div class="meret_container">
                    <tree:formatBytes bytes="${torrent.size}"/>
                </div>
                <div class="dsl_container">
                    ${torrent.downloaded}
                </div>
                <div class="dsl_container">
                    <a href="torrent_details.tt?id={torrent.entry}#peers">${torrent.seeders}</a>
                </div>
                <div class="dsl_container">
                    <a href="torrent_details.tt?id={torrent.entry}#peers">${torrent.leechers}</a>
                </div>
                <div class="feltolto_container">
                    <a href="$ {createLink(controller:'users', action: 'view', params:[user: torrent.uploader.username])}">${torrent.uploader.username}</a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="torrent_details_content" id="detail_${torrent.id}">
    <div class="content" id="detail_${torrent.id}_content">
        <b>Torrent leirása:</b><br/><br/>
        <g:if test="${torrent.description}">
            ${torrent.description}
        </g:if>
        <g:else>
            ..:: Nincs leirás ::..
        </g:else>
    </div>
</div>
</g:each --%>

<br/><br/>

<div class="large_window_top">
    <div class="legend">Lapozó</div>
</div>
<div class="large_window_bevel">
    <div class="content">
        <div class="pager">
            <c:if test="${page > 1}">
                [<a href="?p=1">Első oldal</a>]
                [<a href="?p=${page-1}">Előző</a>]
            </c:if>

            [
            <c:forEach begin="0" end="${count / 25}" step="1" var="vpage" varStatus="vs">
                <c:choose>
                    <c:when test="${(vpage+1) == page}"><span class="rep3">${page}</span></c:when>
                    <c:otherwise><a href="?p=${vpage+1}">${vpage + 1}</a></c:otherwise>
                </c:choose>
                <c:if test="${!vs.last}"> | </c:if>
                <c:if test="${vs.last}"><c:set var="pageCnt" value="${vs.index + 1}"/></c:if>
            </c:forEach>
            ]

            <c:if test="${page < pageCnt}">
                [<a href="?p=${page+1}">Következő</a>]
                [<a href="?p=${pageCnt}">Utolsó oldal</a>]
            </c:if>
        </div>
    </div>
</div>
<br/><br/>