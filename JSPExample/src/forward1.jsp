<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forward request to another JSP</title>
</head>
<body>
    <%
    String name = request.getParameter("name");
    if (name != null) {
        %>
        <jsp:forward page="forward2.jsp">
            <jsp:param name="date" value="<%=new java.util.Date() %>"/>
        </jsp:forward>
        <%
    } else {
        %>
        <form action="forward1.jsp" method="get">
            <p>Type your first name and press Submit</p>
            <p>
                <input type="text" name="name">
                <input type="submit" value="Submit">
            </p>
        </form>
        <%
    }
    %>
</body>
</html>