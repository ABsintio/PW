<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ottenere il colore di JellyBean</title>
</head>
<%@page language="java"%>
<jsp:useBean id="jb" scope="session" class="src.beans.JellyBean"/>
<body>
    <jsp:setProperty name="jb" property="color" param="newColor"/>
    Il colore del bean è stato impostato al valore:
    <jsp:getProperty name="jb" property="color"/>
</body>
</html>