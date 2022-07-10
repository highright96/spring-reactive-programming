CREATE TABLE IF NOT EXISTS ARTICLES
(
    id                     VARCHAR(60)  NOT NULL PRIMARY KEY,
    content                VARCHAR      NOT NULL,
    title                  VARCHAR      NOT NULL,
    username               VARCHAR(60)  NOT NULL,
    user_avatar_image_url  VARCHAR(256) NOT NULL,
    created_at             TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);