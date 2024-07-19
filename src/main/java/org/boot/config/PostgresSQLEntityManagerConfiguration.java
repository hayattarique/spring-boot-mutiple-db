package org.boot.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

@EnableJpaRepositories(basePackages = "org.boot.repositories.postgres",
        entityManagerFactoryRef = "postgresSQLEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager")
@Configuration
public class PostgresSQLEntityManagerConfiguration {


    @Bean
    public LocalContainerEntityManagerFactoryBean postgresSQLEntityManagerFactory(
            @Qualifier("postgresDataSource") DataSource dataSource, EntityManagerFactoryBuilder entityManagerFactoryBuilder) {

        return entityManagerFactoryBuilder.dataSource(dataSource).packages("org.boot.entities.postgres")
                .properties(Map.of("hibernate.hbm2ddl.auto", "create-drop")).build();

    }

    @Bean
    PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresSQLEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
}
