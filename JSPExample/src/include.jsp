<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Include JSP Action</title>
    <style>
        body {
            font-family: tahoma, Arial, Helvetica, sans-serif;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <td style="width: 160px; text-align: center;">
                <img src="https://www.paeseitaliapress.it/img/articoli/89471500909603"
                     width="140" height="93"
                >
            </td>
            <td>
                <%-- include banner.html in this JSP --%>
                <jsp:include page="html/banner.html" flush="true"/>
            </td>
        </tr>
        <tr>
            <td style="width: 160px;">
                <%-- include toc.html in this JSP --%>
                <jsp:include page="html/toc.html" flush="true"/>
            </td>
            <td style="vertical-align: top;">
                <%-- include clock02.jsp in this JSP --%>
                <jsp:include page="clock02.jsp" flush="true"/>
            </td>
        </tr>
    </table>
</body>
</html>