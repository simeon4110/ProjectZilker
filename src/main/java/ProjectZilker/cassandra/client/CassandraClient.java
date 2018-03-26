package ProjectZilker.cassandra.client;

import ProjectZilker.Models.User;
import ProjectZilker.cassandra.client.repository.KeyspaceRepository;
import ProjectZilker.cassandra.client.repository.UserRepository;
import com.datastax.driver.core.Session;

import java.util.UUID;

public abstract class CassandraClient {
    private static CassandraConnector connector = new CassandraConnector();

    public static void saveUser(User user) {
        connector.connect("127.0.0.1", 9142);
        Session session = connector.getSession();
        KeyspaceRepository keyspaceRepository = new KeyspaceRepository(session);
        keyspaceRepository.createKeyspace("users", "SimpleStrategy", 1);
        keyspaceRepository.useKeyspace("users");
        UserRepository repository = new UserRepository(session);
        repository.addUser(user);
    }

    public static User getUser(UUID userID) {
        connector.connect("127.0.0.1", 9142);
        Session session = connector.getSession();
        KeyspaceRepository keyspaceRepository = new KeyspaceRepository(session);
        keyspaceRepository.createKeyspace("users", "SimpleStrategy", 1);
        keyspaceRepository.useKeyspace("users");
        UserRepository repository = new UserRepository(session);
        return repository.getUser(userID);
    }
}
