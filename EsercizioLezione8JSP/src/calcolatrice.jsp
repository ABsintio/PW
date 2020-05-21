<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calcolatrice JSP</title>
    <link rel="stylesheet" href="css/calcolatrice.css">
</head>
<%@page language="java"%>
<jsp:useBean id="gb" scope="page" class="src.beans.genericBean"/>
<body>
    <h1>Semplice calcolatrice</h1>
    <%
        // Prendiamo i parametri
        String parametroA = request.getParameter("a");
        String parametroB = request.getParameter("b");
        String operatore = request.getParameter("operator");
        int result = 0;

        // Controllo se sono stati inseriti i valori
        if (parametroA != null && parametroB != null){

            // Controlla se i valori inseriti non sono lettere
            try {
            
                int a = Integer.parseInt(parametroA);
                int b = Integer.parseInt(parametroB);
                
                switch(operatore) {
                    case "Somma":
                        result = a + b;
                        break;
                    case "Differenza":
                        result = a - b;
                        break;
                    case "Prodotto":
                        result = a * b;
                        break;
                    case "Divisione":
                        result = a > b ? a / b : b / a;
                        break;
                    default:
                        result = a + b;
                }

            } catch (Exception e) {
                
                e.printStackTrace();

            }
        }
    %>
    <%
        if (result != 0) {
            %>
                <jsp:setProperty name="gb" property="value" param="result" />
            <%
        }
    %>
    <div class="container-flex">
        <div id="form">
            <form action="calcolatrice.jsp" method="get">
                <div id="a">
                    <label for="a">a = </label>
                    <%
                        String a = request.getParameter("a");
                        if (a != null) {
                            %>
                            <input type="text" 
                                   placeholder="Insert parameter A" 
                                   name="a" 
                                   value="<%=a%>"
                                   id="inputa"
                                   required="true"
                            >
                            <%
                        } else {
                            %>
                            <input type="text" 
                                   placeholder="Insert parameter A" 
                                   name="a"
                                   id="inputa"
                                   required="true"
                            >
                            <%
                        }
                    %>
                    <select name="operator" id="op">
                        <option value="Somma">+</option>
                        <option value="Differenza">-</option>
                        <option value="Prodotto">*</option>
                        <option value="Divisione">/</option>
                    </select>
                </div>
                <div id="b">
                    <label for="b">b =</label>
                    <%
                        String b = request.getParameter("b");
                        if (b != null) {
                            %>
                            <input type="text" 
                                   placeholder="Insert parameter B" 
                                   name="b" 
                                   value="<%=b%>"
                                   id="inputb"
                                   required="true"
                            >
                            <%
                        } else {
                            %>
                            <input type="text" 
                                   placeholder="Insert parameter B" 
                                   name="b"
                                   id="inputb"
                                   required="true"
                            >
                            <%
                        }
                    %>
                    <input type="submit" value="=">
                </div>
                <div id="risultato">
                    <input type="text" name="risultato" readonly="true" id="result"
                           value="<%=String.valueOf(result)%>">
                </div>
            </form>
        </div>
    </div>
    <h3>Cronologia: <jsp:getProperty name="gb" property="value"/></h3>
</body>
</html>