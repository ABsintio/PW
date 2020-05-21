<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clock JSP Page</title>
</head>
<body>
    <table>
        <tr>
            <td style="background-color: black;">
                <p class="big" style="color: cyan; font-size: 3em; font-weight: bold;">
                    <%-- script to determine client local and format date accordingly --%>
                    <%
                    // get client locale
                    java.util.Locale locale = request.getLocale();

                    // get DateFormat for client's Locale
                    java.text.DateFormat dateFormat = java.text.DateFormat.getDateTimeInstance(
                        java.text.DateFormat.LONG,
                        java.text.DateFormat.LONG, locale
                    );
                    %> 
                    <%=dateFormat.format(new java.util.Date())%>
                </p>
            </td>
        </tr>
    </table>
</body>
</html>