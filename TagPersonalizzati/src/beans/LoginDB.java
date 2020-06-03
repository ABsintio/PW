package beans;

import java.util.*;
import java.io.Serializable;

public class LoginDB implements  Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Vector<User> users = new Vector<>();
    private User[] defaultUsers = {new User("Picasso", "Pablo", "Il mio nome"), };

    public LoginDB() {
        for (int i = 0; i < this.defaultUsers.length; i++) {
            this.users.add(defaultUsers[i]);
        }
    }

    public void addUser(String uname, String pwd, String hint) {
        this.users.add(new User(uname, pwd, hint));
    }

    public User getUser(String uname, String pwd) {
        Iterator<User> it = this.users.iterator();
        User bean;
        synchronized (this.users) {
            while (it.hasNext()) {
                bean = (User) it.next();
                if (bean.equals(uname, pwd)) return bean;
            }
        }
        return null;
    }

    public String getHint(String uname) {
        Iterator<User> it = this.users.iterator();
        User bean;
        synchronized (this.users) {
            while (it.hasNext()) {
                bean = (User) it.next();
                if (bean.getUserName().equals(uname)) return bean.getHint();
            }
        }
        return null;
    }
    
}