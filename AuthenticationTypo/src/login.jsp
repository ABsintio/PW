<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <font size="4" color="blue">
        Per favore inserisci i tuoi dati: <br>
    </font>
    <!-- L'azione del modulo di login viene chiamata con j_security_check -->
    <form action="/AuthenticationTypo/j_security_check" method="POST">
        <table>
            <tr>
                <td>Name: </td>
                <!-- Il nome del campo username deve essere j_username -->
                <td><input type="text" name="j_username" required="true"></td>
            </tr>
            <tr>
                <td>Password: </td>
                <!-- Il nome del campo username deve essere j_password -->
                <td><input type="password" name="j_password" size="8" required="true"></td>
            </tr>
        </table>
        <input type="submit" value="login">
    </form>

    <!--
        La pagina di login così definita viene automaticamente richiamata dal servlet container quando si
        tenta di accedere alla risorsa protetta specificata nel descrittore
    -->
</body>
</html>