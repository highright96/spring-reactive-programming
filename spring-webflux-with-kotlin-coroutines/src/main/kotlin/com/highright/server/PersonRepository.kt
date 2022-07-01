package com.highright.server

interface PersonRepository {

    suspend fun findById(id: String): Person?;
}