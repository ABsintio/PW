import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(
            "absintio098@gmail.com", "predator098"
        );
    }
    
}