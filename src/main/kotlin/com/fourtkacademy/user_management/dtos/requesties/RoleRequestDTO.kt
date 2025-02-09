package com.fourtkacademy.user_management.dtos.requesties

import com.fasterxml.jackson.annotation.JsonProperty
import com.fourtkacademy.user_management.enums.StatusEnum
import java.time.LocalDateTime

data class RoleRequestDTO(
    val descricao: String,
    @JsonProperty("creation_date")
    val creationDate  : LocalDateTime? = LocalDateTime.now()
)