<html>
<head>
    <title>Login Page</title>
</head>
<%@taglib uri="/WEB-INF/tlds/security.tld" prefix="security" %>
<body>
    <font size=4 color="red">Login Failed because:
    <security:showErrors /></font>
    Click <a href="./src/login.jsp">here </a> to retry login.
</body>
</html>