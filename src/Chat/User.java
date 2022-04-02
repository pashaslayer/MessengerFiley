package Chat;

public class User {

    private int userId;
    private String email;
    private String username;
    private String password;

    public void setUserId(int userId) {
        if(userId >= 0){
            this.userId = userId;
        }
        else{
            System.out.println("Wrong UserId! ");
        }
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUsername(String username) {
        if(username != null){
            this.username = username;
        }
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(username != null){
            this.email = email;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password != null) {
            this.password = password;
        }
    }


    public User(int userId, String username, String email, String password) {
        setUserId(userId);
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public User(){
        this.userId = 99999;
        this.username = "";
        this.email = "";
        this.password = "";
    }

    @Override
    public String toString() {
        return this.email + "\n" + this.username + "\n" + this.password + "\n\n";
    }
}
