package org.example.configuration;

import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:application.properties")

public class LiquibaseConfig {

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        DataBaseConfig dataBaseConfig = new DataBaseConfig();
        dataSource.setJdbcUrl(dataBaseConfig.getUrl());
        dataSource.setUsername(dataBaseConfig.getUser());
        dataSource.setPassword(dataBaseConfig.getPassword());
        return dataSource;
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }
}


