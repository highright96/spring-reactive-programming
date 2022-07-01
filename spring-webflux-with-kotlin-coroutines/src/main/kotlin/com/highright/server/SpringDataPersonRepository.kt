package com.highright.server

import io.r2dbc.spi.ConnectionFactory
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.r2dbc.core.awaitOneOrNull
import org.springframework.data.relational.core.query.Criteria
import org.springframework.data.relational.core.query.Query.query
import org.springframework.stereotype.Repository

@Repository
class SpringDataPersonRepository(
    private val h2ConnectionFactory: ConnectionFactory
) : PersonRepository {

    private val template: R2dbcEntityTemplate = R2dbcEntityTemplate(h2ConnectionFactory);

    override suspend fun findById(id: String): Person? {
        return template.select(Person::class.java)
            .from("person")
            .matching(query(Criteria.where("id").`is`(id)))
            .awaitOneOrNull();
    }
}