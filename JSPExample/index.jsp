<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Page Example</title>
</head>
<body>
    <% 
        String name = request.getParameter("firstName");

        if (name != null){
            %> <%-- end scriplet to insert fixed template data --%>
                <h1>Hello <%=name%>,</br>Welcome to JavaServer Pages!</h1>
            <% 
        } else { 
            %>
                <form action="index.jsp" method="GET">
                    <p>Type your first name and press submit</p>
                    <p>
                        <input type="text" name="firstName" />
                        <input type="submit" value="Submit" />
                    </p>
                </form>
            <%
        }
    %>

    <a href="./src/esempioEspressione.jsp.jsp">Esempio di Espressione</a>
    <a href="./src/esempioDichiarazione.jsp.jsp">Esempio di Dichiarazione</a>
    <a href="./src/esempioOggettoPage.jsp">Esempio di uso oggetto Page</a>
</body>
</html>