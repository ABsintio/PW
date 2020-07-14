<html>
<head><title>Send Email by Form</title></head>
<%@page language="java" import="javax.mail.*, javax.mail.internet.*, java.util.*"%>
<body>
    <%
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.Fastwebnet.it");
        prop.put("mail.smtp.port", 587);
        Session s = Session.getInstance(prop, null);
        MimeMessage message = new MimeMessage(s);
        InternetAddress from = new InternetAddress("absintio098@gmail.com");
        message.setFrom(from);
        InternetAddress to = new InternetAddress(request.getParameter("to"));
        message.addRecipient(Message.RecipientType.TO, to);
        message.setSubject(request.getParameter("subject"));
        message.setText(request.getParameter("text"));
        Transport.send(message);
    %>
    E' stato spedito un messaggio di email, clicca 
    <a href="/EmailSenderJSP/src/html/form.html">qui</a> per inviarne un altro.
</body>
</html>