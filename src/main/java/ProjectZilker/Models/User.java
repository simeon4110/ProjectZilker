package ProjectZilker.Models;

import ProjectZilker.cassandra.client.CassandraClient;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import org.joda.time.DateTime;

import java.util.UUID;

@Table(keyspace = "users", name = "data")
public class User {
    @PartitionKey
    @Column
    private final UUID id;
    @Column
    private String name;
    @Column
    private String timeStamp;

    public User(String name) {
        this.id = UUID.randomUUID();
        this.timeStamp = DateTime.now().toString();
        this.name = name;

        CassandraClient.saveUser(this);
    }

    public User(UUID id, String name, String timeStamp) {
        this.id = id;
        this.name = name;
        this.timeStamp = timeStamp;
    }

    public void get() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public UUID getId() {
        return id;
    }
}
