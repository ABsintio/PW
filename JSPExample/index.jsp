<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Page Example</title>
</head>
<body>
    <% // Begin scriplet

        // Uso dell'oggetto implicito request per ottenere il valore
        // di un parametro.
        String name = request.getParameter("firstName");

        if (name != null){
            %> <%-- end scriplet to insert fixed template data --%>
                <h1>Hello <%=name%>,</br>Welcome to JavaServer Pages!</h1>
            <% // continue scriplet
        } else { // end if
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
</body>
</html>