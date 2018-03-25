package ProjectZilker.Models;

import java.util.UUID;

public abstract class Content {
    private String id;
    private User poster;
    private int karma = 0;
    private String subID;

    private boolean isNSFW;
    private boolean isSpoiler;


    public Content(User poster, boolean isNSFW, boolean isSpoiler, String subID) {
        this.id = newKey();
        this.poster = poster;
        this.isNSFW = isNSFW;
        this.isSpoiler = isSpoiler;

        this.subID = subID;
    }

    public Content(User poster) {
        this.poster = poster;
    }

    public void upVote() {
        this.karma++;
    }

    public void downVote() {
        this.karma--;
    }

    private String newKey() {
        return UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public User getPoster() {
        return poster;
    }
}
