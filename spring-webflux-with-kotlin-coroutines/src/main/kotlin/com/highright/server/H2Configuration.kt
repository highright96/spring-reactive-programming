package com.highright.server

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class H2Configuration {

    @Bean
    fun h2ConnectionFactory(): ConnectionFactory {
        return ConnectionFactories.get("r2dbc:h2:mem:///testdb")
    }
}