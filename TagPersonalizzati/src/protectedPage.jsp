<html>
<head>
    <title>Una pagina protetta</title>
</head>
<%@taglib uri="/WEB-INF/tlds/lib.tld" prefix="security" %>
<body>
    <security:enforceLogin loginPage="/login.jsp" errorPage="/error.jsp"/>
    <jsp:useBean id="user" type="beans.User" scope="session">
    Questa è una pagina protetta. Benvenuto <%= user.getUserName() %>
</body>
</html>