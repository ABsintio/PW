<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <!-- Refresh ogni 10 secondi -->
    <meta http-equiv="refresh" content="10">
    <title>Esempio di utilizzo espressioni</title>
</head>
<body>
    <!-- 
        - Viene creata la struttura della pagina attraverso HTML
        - Viene creato un oggetto (java.util.Date)
        - Viene effettuata la conversione automatica di un'espressione JSP in String
        - Viene usato un meta-elemento per ricaricare la pagina a specifici intervalli

        Si noti alla prima invocazione della pagina il ritardo con cui
        - Il JSP container traduce la pagina JSP in una servlet
        - Il JSP container compila la servlet
        - Il JSP container esegue la servlet

        Le successive richieste non sperimentano questo ritardo.
    -->

    <style>
        p {
            font-family: Arial, Helvetica, sans-serif;
            font-weight: bold;
            font-size: 2em;
        }
        p#big1 {
            color: cyan;
        }
        table {
            border: 6px outset;
        }
        td {
            background-color: black;
        }
    </style>

    <p class="big">Simple JSP Example</p>
    <table>
        <tr>
            <td>
                <p clas="big" id="big1">
                    <%=new java.util.Date() %>
                </p>
            </td>
        </tr>
    </table>
</body>
</html>