package beans;

import java.io.*;

public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String userName;
    private String password;
    private String hint;

    public User(){}

    public User(String u, String p, String h) {
        this.userName = u;
        this.password = p;
        this.hint = h;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getHint() {
        return this.hint;
    }

    public boolean equals(String uname, String pwd) {
        return (this.getUserName().equals(uname) && this.getPassword().equals(pwd));
    }

}