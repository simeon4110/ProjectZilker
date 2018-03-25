package ProjectZilker.Models;

import java.util.ArrayList;

public class User {
    private String id;
    private String name;

    private ArrayList<User> friends;
    private ArrayList<User> blocked;
    private ArrayList<User> trusted;

    public User(String name) {
        this.name = name;

        this.friends = new ArrayList<User>();
        this.blocked = new ArrayList<User>();
        this.trusted = new ArrayList<User>();
    }

    public void addFriend(User user) {
        this.friends.add(user);
    }

    public void addBlocked(User user) {
        this.blocked.add(user);
    }

    public void addTrusted(User user) {
        this.trusted.add(user);
    }

    public void removeFriend(User user) {
        this.friends.remove(user);
    }

    public void removeBlocked(User user) {
        this.blocked.remove(user);
    }

    public void removeTrusted(User user) {
        this.trusted.remove(user);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
