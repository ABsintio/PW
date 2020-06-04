<html>
<head>
    <title>Una pagina protetta</title>
</head>
<%@taglib uri="/WEB-INF/tlds/security.tld" prefix="security" %>
<body>
    <security:enforceLogin loginPage="/src/login.jsp" errorPage="/src/error.jsp"/>
    <jsp:useBean id="user" type="beans.User" scope="session" />
    Questa è una pagina protetta. Benvenuto <%= user.getUserName() %>
</body>
</html>