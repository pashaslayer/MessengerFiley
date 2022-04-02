package File;

import Chat.User;

import java.util.HashMap;

public class FileStream {

    private User userReciever;
    private User userSender;
    private HashMap<String, Integer> hashedMessage = new HashMap<String, Integer>();

    public User getUserReciever() {
        return userReciever;
    }

    public void setUserReciever(User userReciever) {
        this.userReciever = userReciever;
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public void setHashedMessage(TextMessage message) {
        this.hashedMessage.put(message.getMessage(), message.getMessage().hashCode());
    }

    public FileStream(User reciever, User sender, TextMessage textMessage) {
        setUserReciever(reciever);
        setUserSender(sender);
        setHashedMessage(textMessage);
    }

}
