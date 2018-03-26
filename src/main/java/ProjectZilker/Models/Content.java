package ProjectZilker.Models;

import java.util.UUID;

public abstract class Content {
    private final UUID id = UUID.randomUUID();
    private User poster;
    private int karma = 0;
    private UUID subID;

    private boolean isNSFW;
    private boolean isSpoiler;

    public Content(User poster, boolean isNSFW, boolean isSpoiler, UUID subID) {
        this.poster = poster;
        this.isNSFW = isNSFW;
        this.isSpoiler = isSpoiler;

        this.subID = subID;
    }

    public Content(User poster, UUID subID) {
        this.poster = poster;
        this.subID = subID;
        this.isNSFW = false;
        this.isSpoiler = false;
    }

    public void upVote() {
        this.karma++;
    }

    public void downVote() {
        this.karma--;
    }

    public UUID getId() {
        return id;
    }

    public User getPoster() {
        return poster;
    }

    public UUID getSubID() {
        return subID;
    }
}
