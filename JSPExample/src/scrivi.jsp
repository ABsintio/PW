<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Impostazione del colore di JellyBean</title>
    <%@page language="java"%>
    <jsp:useBean id="jb" scope="session" class="src.beans.JellyBean">
</head>
<body>
    <form action="leggi.jsp" method="get">
        <strong>Scegli il colore del bean: </strong><br>
        <label for="">Rosso
            <input type="radio" name="newColor" id="" value="red" checked="checked">
        </label>
        <label for="">Verde
            <input type="radio" name="newColor" id="" value="green">
        </label>
        <label for="">Giallo
            <input type="radio" name="newColor" id="" value="yellow">
        </label>
        <input type="submit" value="Submit">
    </form>
</body>
</html>