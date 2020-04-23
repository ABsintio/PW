<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Esempio di utilizzo dell'oggetto Page</title>
</head>
<body>
    <%@ page info="Esempio di uso page."%>
    <h1>Page info: <%=page.getServletInfo() %></h1>
</body>
</html>