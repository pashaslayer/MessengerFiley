package Chat;

import Chat.User;

public class Administrator extends User {

    //  Admins können nur die userId 0 haben
    Administrator(int userId, String username, String email, String password) {
        super(userId, username, email, password);
        setUserId(0);
    }

    @Override
    public String toString() {
        return getUserId() + "\n" + super.toString() + getEmail() + "\n";
    }
}
