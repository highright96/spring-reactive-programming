package com.highright.simplechatapplication.service.mapper

import com.highright.simplechatapplication.controller.dto.ArticleRequest
import com.highright.simplechatapplication.controller.dto.ArticleResponse
import com.highright.simplechatapplication.domain.Article
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface ArticleMappers {
//
//    @Mappings(
//        Mapping(source = "user.name", target = "username"),
//        Mapping(source = "user.avatarImageUrl", target = "userAvatarImageUrl")
//    )
    fun toArticle(request: ArticleRequest): Article

    @Mappings(
        Mapping(source = "username", target = "user.name"),
        Mapping(source = "userAvatarImageUrl", target = "user.avatarImageUrl"),
    )
    fun toArticleResponse(article: Article): ArticleResponse
}