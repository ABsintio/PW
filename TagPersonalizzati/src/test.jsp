<html>
<head>
    <title>Un iteratore</title>
    <%@page language="java" import="java.util.Vector"%>
</head>
<%@taglib uri="/WEB-INF/tlds/iterator.tld" prefix="it"%>
<body>
    <%
        Vector vector = new Vector();
        vector.addElement("el_uno");
        vector.addElement("el_due");
        vector.addElement("el_tre");
        vector.addElement("el_quattro");
    %>
    Iterating over <%= vector %> ...
    <p>
    <it:iterate collection="<%= vector %>">
        <jsp:useBean id="item" scope="page" class="java.lang.String"/>
        Item: <%= item%><br>
    </it:iterate>
    </p>
</body>
</html>