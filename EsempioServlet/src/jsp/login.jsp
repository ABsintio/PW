<!DOCTYPE html>
<html lang="it" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Login Page</title>
</head>
<body>
    <form action="j_security_check" method="post">
        <p><table>
            <tr>
                <td><b>Username: </b></td>
                <td><input type="text" name="j_username" required="true"></td>
            </tr>
            <tr>
                <td><b>Password: </b></td>
                <td><input type="password" name="j_password" required="true"></td>
            </tr>
        </table></p>
        <input type="submit" value="LogIn">
    </form>
</body>
</html>
