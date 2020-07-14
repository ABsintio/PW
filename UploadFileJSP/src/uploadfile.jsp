<html>
<head>
    <title>JSP per l'upload del file dal client</title>
</head>
<%@page language="java"%>
<%@page import="org.apache.commons.fileupload.*, java.util.*, java.io.*"%>
<body>
    <%
        boolean isMulpart = FileUpload.isMultipartContent(request);
        DiskFileUpload upload = new DiskFileUpload();
        upload.setSizeThreshold(5000);
        upload.setRepositoryPath(getServletContext().getRealPath("/") + "tempo");
        upload.setSizeMax(500000);

        List items = upload.parseRequest(request);
        Iterator it = items.iterator();
        while (it.hasNext()) {
            FileItem fi = (FileItem) it.next();
            if (fi.isFormField()) {
                String fieldName = fi.getFieldName();
                if (fielName.equals("nome")) {
                    %>
                    <h1>Ciao <%=fi.getString() %> </h1>
                    <%
                }
            } else {
                File fullFile = new File(fi.getName());
                %>
                <br>
                Il file di cui hai richiesto l'upload è: <%=fi.getName() %>
                <br><br>
                Il nome del file senza percorso sul client è il seguente: <%=fullFile.getName()%>
                <br><br>
                Lo metteremo invece in questa directory:
                <%=getServletContext().getRealPath("/") + "definitivi"%>
                <br>
                <%
                File savedFile = new File(
                    getServletContext().getRealPath("/"),
                    "definitivi\\" + fullFile.getName();
                );
                fi.write(savedFile);
            }
        }
    %>
</body>
</html>