package ProjectZilker.cassandra.client.repository;

import ProjectZilker.Models.User;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import java.util.UUID;

public class UserRepository {
    private static final String TABLE_NAME = "users.data";
    private Session session;

    public UserRepository(Session session) {
        this.session = session;
        this.createTable();
    }

    public void createTable() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append(TABLE_NAME).append("(")
                .append("id uuid PRIMARY KEY, ")
                .append("name text,").append("timeStamp text);");

        final String query = sb.toString();
        this.session.execute(query);
    }

    public void addUser(User user) {
        StringBuilder sb = new StringBuilder("INSERT INTO ").append(TABLE_NAME).append("(id, name, timeStamp) ")
                .append("VALUES (").append(user.getId()).append(", '")
                .append(user.getName()).append("', '")
                .append(user.getTimeStamp()).append("');");

        final String query = sb.toString();
        this.session.execute(query);
    }

    public User getUser(UUID userID) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(TABLE_NAME).append(" WHERE id  = ").append(userID).append(";");

        final String query = sb.toString();

        Row row = session.execute(query).one();
        this.session.execute(query);

        return new User(row.getUUID("id"), row.getString("Name"), row.getString("timeStamp"));
    }

}
