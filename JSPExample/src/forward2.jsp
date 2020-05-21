<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Processing a forwarded request</title>
    <style>
        .big {
            font-family: Arial, Helvetica, sans-serif;
            font-weight: bold;
            font-size: 2em;
        }
    </style>
</head>
<body>
    <p class="big">
        Hello <%=request.getParameter("name")%>, <br>
        Your request was received <br> and forwarded at
    </p>
    <table style="border: 6px outset;">
        <tr>
            <td style="background-color: black;">
                <p class="big" style="color: cyan;">
                    <%=request.getParameter("date")%>
                </p>
            </td>
        </tr>
    </table>
</body>
</html>