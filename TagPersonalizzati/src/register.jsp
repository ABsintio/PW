<html>
<head>
    <title>Pagina di registrazione con Form</title>
</head>
<%@taglib uri="/WEB-INF/tlds/lib.tld" prefix="util"%>
<body>
    <h1>Inserisci le tue credenziali</h1>
    <table>
        <tr>
            <td>Nome: </td>
            <td><input type="text" 
                       name="firstName" 
                       value="<form_util:requestParameter value='firstName'/>">
            </td>
        </tr>
        <tr>
            <td>Cognome: </td>
            <td><input type="text" 
                       name="lastName" 
                       value="<form_util:requestParameter value='lastName'/>">
            </td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><input type="email" 
                       name="emailAddress" 
                       value="<form_util:requestParameter value='emailAddress'/>">
            </td>
        </tr>
    </table>
</body>
</html>