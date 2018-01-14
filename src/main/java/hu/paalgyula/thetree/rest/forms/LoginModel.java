package hu.paalgyula.thetree.rest.forms;

/**
 * Model for login request
 */
public class LoginModel {
    private String username;
    private String password;
    private boolean remember;

    public LoginModel() {
    }

    public LoginModel(String username, String password, boolean remember) {
        this.username = username;
        this.password = password;
        this.remember = remember;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }
}
