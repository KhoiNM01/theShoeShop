package Model;

public class Account {
    private int userId;
    private String username;
    private String password;
    private String fullName;
    private Boolean isAdmin;
    private String email;

    public Account(int userId, String username, String password, String fullName, boolean isAdmin, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.isAdmin = isAdmin;
        this.email = email;
    }

    public Account() {
        
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
