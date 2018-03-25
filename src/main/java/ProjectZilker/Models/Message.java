package ProjectZilker.Models;

public class Message {
    private String id;
    private User sender;
    private User recipient;
    private String title;
    private String content;

    public Message(User sender, User recipient, String title, String content) {
        this.sender = sender;
        this.recipient = recipient;
        this.title = title;
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
