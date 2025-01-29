package org.example.config;

import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.example.configuration.DataBaseConfig;
import org.example.dao.Impl.UserDaoImpl;
import org.example.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class ConfigurationDbTest {

    public ConfigurationDbTest(){}
    @Bean
    @Profile("test")
    public DataSource dataSource(Environment environment) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return dataSource;
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

    @Bean
    public DataBaseConfig dataBaseConfig(Environment environment) {
        // Подключение к H2 (или другой тестовой базе)
        return new DataBaseConfig(environment.getProperty("spring.datasource.username"),environment.getProperty("spring.datasource.password"),environment.getProperty("spring.datasource.url"));
    }

    @Bean
    public UserDao userDao(DataBaseConfig dataBaseConfig) {
        return new UserDaoImpl(dataBaseConfig);
    }
}
