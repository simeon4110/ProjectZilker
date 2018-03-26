package ProjectZilker.Models;

import ProjectZilker.cassandra.client.CassandraClient;
import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.UUID;

public class UserTest {
    private UUID user_id;

    @BeforeClass
    public static void init() throws ConfigurationException, TTransportException, IOException, InterruptedException {
        // Start an embedded Cassandra Server
        EmbeddedCassandraServerHelper.startEmbeddedCassandra(20000L);
    }

    @Test
    public void createUser() {
        User user = new User("Josh");
        this.user_id = user.getId();
        System.out.println(this.user_id);
        CassandraClient.saveUser(user);

        User retUser = CassandraClient.getUser(this.user_id);

        System.out.println(retUser.getName());
    }

//    @Test
//    public void getUser() {
//        System.out.println(user_id);
//        User userTest = CassandraClient.getUser(this.user_id);
//        System.out.println(userTest.getId());
//    }

}
