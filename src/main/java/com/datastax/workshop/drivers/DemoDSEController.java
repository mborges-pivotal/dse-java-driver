package com.datastax.workshop.drivers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.policies.DCAwareRoundRobinPolicy;
import com.datastax.driver.dse.DseCluster;
import com.datastax.driver.dse.DseSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/dse")
@RestController
public class DemoDSEController {

    @Value("${dsedriver.contact-point}")
    private String contactPoint;

    @Value("${dsedriver.local-dc}")
    private String dc;

    private DseCluster cluster;
    private DseSession session;

    @GetMapping("/version")
    public String version() {
        System.out.println("*** DSE Driver session query ***");
        ResultSet rs = session.execute("select release_version from system.local");
        Row row = rs.one();
        assert row != null;
        String releaseVersion = row.getString("release_version");
        return String.format("Cassandra version is: %s%n", releaseVersion);
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("PostConstruct: Creating DseCluster and DseSession objects to DSE");
        System.out.println("PostConstruct: contactPoint: " + contactPoint);
        cluster = DseCluster.builder().addContactPoint(contactPoint).withoutMetrics()
                .withLoadBalancingPolicy(DCAwareRoundRobinPolicy.builder().withLocalDc(dc).build()).build();
        session = cluster.connect();
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("PreDestroy: Closing DseCluster object from DSE");
        if (null != cluster) {
            cluster.close();
        }
    }

}
