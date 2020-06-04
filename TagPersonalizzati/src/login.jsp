<html>
<head>
    <title>Login Page</title>
</head>
<%@taglib uri="/WEB-INF/tlds/security.tld" prefix="security" %>
<body>
    <font size=4 color="red"><security:showErrors /></font>
    <p><font size=5 color="blue">Please Login</font> <hr>
    <form action="/TagPersonalizzati/authenticate" method="POST">
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="userName" /></td>
            </tr><tr>
                <td>Password: </td>
                <td><input type="password" name="password" size="8" /></td>
            </tr> 
        </table>
        <input type="submit" value="login">
    </form></p>
    Ricorda che un nome valido è: Picasso e password: Pablo
</body>
</html>