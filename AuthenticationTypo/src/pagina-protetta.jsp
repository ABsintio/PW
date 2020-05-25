<html>
<head>
    <title>Una pagina protetta</title>
</head>
<body>
    <%@ include file="show-security.jsp" %>
    <% if (request.isUserInRole("tomcat")) { %>
        Appartieni al ruolo <i>tomcat</i><br>
    <% } else { %>
        Non appartieni al ruolo <i>tomcat</i><br>
    <% } %>
    <% if (request.isUserInRole("role1")) { %>
        Appartieni al ruolo <i>role1</i><br>
    <% } else { %>
        Non appartieni al ruolo <i>role1</i><br>
    <% } %>
</body>
</html>