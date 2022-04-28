package com.datastax.workshop.drivers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/dse-oss")
@RestController
public class DemoDSEOSSController {

    private CqlSession session;

    @GetMapping("/version")
    public String version() {
        System.out.println("*** Cassandra OSS Driver ***");
        ResultSet rs = session.execute("select release_version from system.local");
        Row row = rs.one();
        assert row != null;
        String releaseVersion = row.getString("release_version");
        return String.format("Cassandra version is: %s%n", releaseVersion);
    }


    @PostConstruct
    private void postConstruct() {
        System.out.println("PostConstruct: Creating cqlSession object to DSE");
         session = CqlSession.builder().build();
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("PreDestroy: Closing sqlSession object from DSE");
        if (null != session) {
            session.close();
        }
    }

}
