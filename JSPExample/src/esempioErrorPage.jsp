<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Esempio dell'uso oggetto Exception</title>
</head>
<body>
    <!-- Devo mettere l'attributo a true altrimenti l'oggetto Exception non è presente -->
    <%@ page isErrorPage="true" %>
    <h1>Attenzione!</h1>
    <h2>E' stato rilevato il seguente errore: <br></h2>
    <strong><%=exception %></strong><br>
    <% exception.printStackTrace(out) %>
</body>
</html>