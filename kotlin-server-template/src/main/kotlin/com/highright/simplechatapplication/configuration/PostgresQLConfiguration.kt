package com.highright.simplechatapplication.configuration

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions.*
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator
import org.springframework.transaction.ReactiveTransactionManager

@Configuration
@EnableR2dbcRepositories
class PostgresQLConfiguration {

    @Bean
    @Qualifier("postgresQLConnectionFactory")
    fun postgresQLConnectionFactory(): ConnectionFactory {
        val connectionFactory = ConnectionFactories.get(
            builder()
                .option(DRIVER, "postgresql")
                .option(HOST, "localhost")
                .option(PORT, 5432)
                .option(USER, "user")
                .option(PASSWORD, "password")
                .option(DATABASE, "test")
                .build()
        )

        return connectionFactory
        /*
        val configuration = ConnectionPoolConfiguration.builder(connectionFactory)
            .maxCreateConnectionTime(Duration.ofMinutes(5))
            .initialSize(10)
            .maxSize(10)
            .maxIdleTime(Duration.ofMinutes(30))
            .build()

        return ConnectionPool(configuration)
        */
    }

    @Bean
    fun postgresQLTransactionManager(connectionFactory: ConnectionFactory): ReactiveTransactionManager {
        return R2dbcTransactionManager(connectionFactory);
    }

    // 스키마 생성
    @Bean
    fun initializer(connectionFactory: ConnectionFactory): ConnectionFactoryInitializer {
        val initializer = ConnectionFactoryInitializer()
        initializer.setConnectionFactory(connectionFactory)

        val populator = ResourceDatabasePopulator(ClassPathResource("sql/schema.sql"))
        initializer.setDatabasePopulator(populator)

        return initializer
    }
}