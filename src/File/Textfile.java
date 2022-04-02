package File;

public class Textfile {

    // Es können nur Textfiles versendet werden.

    private TextMessage textMessage;

    public TextMessage getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(TextMessage textMessage) {
        this.textMessage = textMessage;
    }

    public Textfile(TextMessage textMessage) {
        this.textMessage = textMessage;
    }

}
