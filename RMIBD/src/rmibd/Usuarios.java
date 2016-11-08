package rmibd;

import java.io.Serializable;

public class Usuarios {

    private String user;
    private String Password;

    public Usuarios(String user, String Password) {

        this.user = user;
        this.Password = Password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}