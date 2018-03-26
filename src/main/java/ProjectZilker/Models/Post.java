package ProjectZilker.Models;

import java.util.UUID;

public class Post extends Content {
    private String title;
    private String content;

    public Post(User user, String title, String content, boolean NSFW, boolean spoiler, UUID subID) {
        super(user, NSFW, spoiler, subID);
        this.title = title;
        this.content = content;

    }

    public void addComment(User user, String content) {
        new Comment(user, this.getId(), content);
    }

    public void addCommentWithParent(User user, Comment parent, String content) {
        new Comment(user, parent, content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }
}
