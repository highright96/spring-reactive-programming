package com.highright.server

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@Table("person")
class Person(
    @Id val id: String,
    val firstname: String,
    val lastname: String
)