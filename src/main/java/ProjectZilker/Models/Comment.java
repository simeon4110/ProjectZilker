package ProjectZilker.Models;

public class Comment extends Content {
    String postID;
    String content;
    Comment parent;

    public Comment(User user, String postID, String content) {
        super(user);
        this.postID = postID;
        this.content = content;
    }

    public Comment(User user, Comment parent, String content) {
        super(user);
        this.postID = parent.getId();
        this.parent = parent;
        this.content = content;
    }

}
