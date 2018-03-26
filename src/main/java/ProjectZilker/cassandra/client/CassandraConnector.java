package ProjectZilker.cassandra.client;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.extras.codecs.joda.InstantCodec;


public class CassandraConnector {
    private static final Logger LOG = LoggerFactory.getLogger(CassandraConnector.class);
    private Cluster cluster;
    private Session session;

    public void connect(final String node, final Integer port) {
        Builder builder = Cluster.builder().addContactPoint(node);

        if (port != null) {
            builder.withPort(port);
        }
        cluster = builder.build();
        cluster.getConfiguration().getCodecRegistry().register(InstantCodec.instance);

        Metadata metadata = cluster.getMetadata();
        LOG.info("Cluster name: " + metadata.getClusterName());

        for (Host h : metadata.getAllHosts()) {
            LOG.info("Datacenter: " + h.getDatacenter() + " Host: " + h.getAddress() + " Rack: " + h.getRack());
        }

        session = cluster.connect();
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}
