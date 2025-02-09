package com.fourtkacademy.user_management.dtos.requesties

import com.fasterxml.jackson.annotation.JsonProperty
import com.fourtkacademy.user_management.enums.StatusEnum
import java.time.LocalDateTime

data class UserRequestDTO(
    val name: String,
    val email: String,
    val password : String,
    val status  : StatusEnum? = StatusEnum.ACTIVE,
    @JsonProperty("creation_date")
    val creationDate  : LocalDateTime? = LocalDateTime.now()
)

//erDiagram
//USER {
//    UUID id
//            VARCHAR nome
//            VARCHAR email UNIQUE
//    VARCHAR senha
//            ENUM status
//            TIMESTAMP data_criacao
//            TIMESTAMP data_atualizacao
//}
//
//ROLE {
//    UUID id
//            VARCHAR nome UNIQUE
//    TEXT descricao
//}
//
//PERMISSION {
//    UUID id
//            VARCHAR nome UNIQUE
//    TEXT descricao
//}
//
//USER_ROLE {
//    UUID id
//            UUID usuario_id FK
//    UUID papel_id FK
//    TIMESTAMP data_atribuicao
//}
//
//ROLE_PERMISSION {
//    UUID id
//            UUID papel_id FK
//    UUID permissao_id FK
//}
//
//USER ||--o{ USER_ROLE : "possui"
//    ROLE ||--o{ USER_ROLE : "tem"
//        ROLE ||--o{ ROLE_PERMISSION : "possui"
//            PERMISSION ||--o{ ROLE_PERMISSION : "tem"
