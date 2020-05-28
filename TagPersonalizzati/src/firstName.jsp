<html>
<head>
    <title>Pagina che visualizza un messaggio di benvenuto</title>
</head>
<%@taglib uri="/WEB-INF/tlds/lib.tld" prefix="util"%>
<body>
    <p>Uso di un attributo dichiarato come stringa</p>
    <h1><util:welcome2 firstName="Paul"/></h1>
    <p>Valutazione del valore di una attributo a tempo di esecuzione</p>
    <h1>
        <%-- scriplet to obtain "name" request parameter --%>
        <%
            String name = request.getParameter("name");
        %>
        <util:welcome2 firstName="<%= name %>"/>
    </h1>
</body>
</html>