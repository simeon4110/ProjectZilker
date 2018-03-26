package ProjectZilker.Models;

import java.util.UUID;

public class Comment extends Content {
    private String content;
    private Comment parent;

    public Comment(User user, UUID subID, String content) {
        super(user, subID);
        this.content = content;
        this.parent = null;


    }

    public Comment(User user, Comment parent, String content) {
        super(user, parent.getSubID());
        this.content = content;
        this.parent = parent;

    }

    public String getContent() {
        return content;
    }

    public Comment getParent() {
        return parent;
    }
}
