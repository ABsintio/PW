<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Esempio JSP sulle dichiarazioni</title>
</head>
<body>
    <%! int counter = 0; %> <%-- Oppure <% int counter=0; %> --%>
    <% counter++; %>
    <h1>Il contatore vale <%=counter %></h1>
    <% counter++; %>
    <h1>Il contatore vale <%=counter %></h1>
</body>
</html>