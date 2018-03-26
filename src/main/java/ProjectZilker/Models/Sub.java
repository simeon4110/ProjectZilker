package ProjectZilker.Models;

import java.util.ArrayList;
import java.util.UUID;

public class Sub {
    private final UUID id = UUID.randomUUID();
    private String name;
    private String description;

    private ArrayList<User> moderators;
    private ArrayList<User> subscribers;
    private ArrayList<User> banned;
    private ArrayList<User> contributors;

    public Sub(String name, String description, User creator) {
        this.name = name;
        this.description = description;
        
        this.moderators = new ArrayList<User>();
        this.subscribers = new ArrayList<User>();
        this.banned = new ArrayList<User>();
        this.contributors = new ArrayList<User>();

        this.moderators.add(creator);
        
    }

    public void addPost(String title, String content, User user, boolean NSFW, boolean spoiler) {
        new Post(user, title, content, NSFW, spoiler, this.id);
    }


    public UUID getId() {
        return id;
    }
}
