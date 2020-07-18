<!DOCTYPE html>
<html lang="it" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Register JSP</title>
</head>
<%@page language="java" import="java.util.*"%>
<body>
    <%! HashMap<String, String> set = new HashMap<String, String>(); %>
    <%
    String name = request.getParameter("name");
    String surname = request.getParameter("cognome");
    if (name != null && surname != null) {
        %><p>Valori inseriti: <%=name%> <%= surname%></p><%
        if (!set.isEmpty()) {
            Iterator<Map.Entry<String, String>> it = set.entrySet().iterator();
            %>
            <h3>Valore Recentemente registrati: </h3>
            <table>
            <%
            int i = 1;
            while (it.hasNext()) {
                Map.Entry<String, String> e = it.next();
                String key = e.getKey();
                String value = e.getValue();
                %>
                    <tr>
                        <td><%= i%>)</td>
                        <td><b>Nome: </b></td>
                        <td><%= key %></td>
                        <td><b>Cognome: </b></td>
                        <td><%= value %></td>
                    </tr>
                <%
            }
            %></table><%
        }
        %>
        <h3>Non ci sono valori recentemente salvati</h3>
        <%
        set.put(name, surname);
    } else {
        %>
        <h3>Non ci sono valori recentemente salvati</h3>
        <%
    }
    %>
    <form action="register.jsp" method="get">
        <p><table>
            <tr>
                <td><strong>Nome: </strong></td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td><strong>Cognome: </strong></td>
                <td><input type="text" name="cognome"></td>
            </tr>
        </table></p>
        <input type="submit" value="Registra">
    </form>
</body>
</html>
