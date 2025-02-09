package com.fourtkacademy.user_management.dtos.requesties

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class RoleRequestDTO(
    val name: String,
    val description: String,
    @JsonProperty("creation_date")
    val creationDate  : LocalDateTime? = LocalDateTime.now()
)