package com.highright.simplechatapplication.service

import com.github.javafaker.Faker
import com.highright.simplechatapplication.domain.User
import java.net.URL

object MockData {
    val users: Map<String, User> = mapOf(
        "Shakespeare" to User(
            "Shakespeare",
            URL("https://blog.12min.com/wp-content/uploads/2018/05/27d-William-Shakespeare.jpg")
        ),
        "RickAndMorty" to User(
            "RickAndMorty",
            URL("http://thecircular.org/wp-content/uploads/2015/04/rick-and-morty-fb-pic1.jpg")
        ),
        "Yoda" to User(
            "Yoda",
            URL("https://news.toyark.com/wp-content/uploads/sites/4/2019/03/SH-Figuarts-Yoda-001.jpg")
        )
    )

    val usersQuotes: Map<String, () -> String> = mapOf(
        "Shakespeare" to { Faker.instance().shakespeare().asYouLikeItQuote() },
        "RickAndMorty" to { Faker.instance().rickAndMorty().quote() },
        "Yoda" to { Faker.instance().yoda().quote() }
    )
}