<html>
<head><title>Pagina che invia un email</title></head>
<%@page language="java" import="javax.mail.*, java.util.*, javax.mail.internet.*, SMTPAuthenticator.*"%>
<body>
    <%
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.Fastwebnet.it");
    props.put("mail.smtp.port", 587);
    Session s = Session.getInstance(props, auth);
    MimeMessage message = new MimeMessage(s);
    InternetAddress from = new InternetAddress("absintio098@gmail.com");
    message.setFrom(from);
    InternetAddress to = new InternetAddress("riccardo.lamarca98@gmail.com");
    message.addRecipient(Message.RecipientType.TO, to);
    message.setSubject("Prova invio email da JSP");
    message.setText("Ciao sono una JSP semplice che invia email");
    Transport.send(message);
    %>
    E' stato spedito un messaggio di email.
</body>
</html>