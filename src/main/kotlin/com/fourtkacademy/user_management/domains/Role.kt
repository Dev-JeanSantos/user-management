package com.fourtkacademy.user_management.domains

import com.fourtkacademy.user_management.enums.StatusEnum
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tb_role")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val descricao: String,
    val creationDate  : LocalDateTime,
    val updateDate  : LocalDateTime? = null
)
