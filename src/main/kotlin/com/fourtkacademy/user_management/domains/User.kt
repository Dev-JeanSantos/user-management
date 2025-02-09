package com.fourtkacademy.user_management.domains

import com.fourtkacademy.user_management.enums.StatusEnum
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tb_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val email: String,
    val password : String,
    @Enumerated(EnumType.STRING)
    val status  : StatusEnum,
    val creationDate  : LocalDateTime,
    val updateDate  : LocalDateTime? = null
)
