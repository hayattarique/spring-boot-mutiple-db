package org.boot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration

public class PostgresSQLConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.pg")
    public DataSourceProperties postgresSQLProperties() {
        return new DataSourceProperties();
    }



    @Bean
    @Primary
    DataSource postgresDataSource(@Qualifier("postgresSQLProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }


}
