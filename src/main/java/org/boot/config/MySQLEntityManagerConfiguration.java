package org.boot.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableJpaRepositories(basePackages = "org.boot.repositories.mysql",
        entityManagerFactoryRef = "mySQLEntityManagerFactory",
        transactionManagerRef = "mySQLTransactionManager")

public class MySQLEntityManagerConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean mySQLEntityManagerFactory(@Qualifier("mysqlDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {

        return builder.dataSource(dataSource).packages("org.boot.entities.mysql")
                .properties(Map.of("hibernate.hbm2ddl.auto", "create-drop")).build();
    }

    @Bean
    PlatformTransactionManager mySQLTransactionManager(@Qualifier("mySQLEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
}
