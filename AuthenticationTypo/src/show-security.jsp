<html>
<head>
    <title>Show security</title>
</head>
<body>
    <font size="4" color="blue">
        Informazioni sulla sicurezza
    </font> <br>
    User principal: <%= request.getUserPrincipal().getName() %>. <br>
    Request authenticated with: <%= request.getAuthType() %>. <br>

    <% if (request.isSecure()) %>
        This connection is secure. <br>
    <% else %>
        This connection is NOT secure. <br>
    
    <!-- Otteniamo informazioni riguardo al server -->
    Server Address: <%= request.getServerName() %> <br>

    <!-- Otteniamo informazioni riguardo all'host remoto -->
    Remote Host: <%= request.getRemoteHost() %> <br>

    <!-- Otteniamo informazioni riguardo all'indirizzo dell'host remoto -->
    Remote Addr: <%= request.getRemoteAddr() %> <br>
</body>
</html>