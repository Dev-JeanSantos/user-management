package com.fourtkacademy.user_management.controllers

import com.fourtkacademy.user_management.dtos.requesties.RoleRequestDTO
import com.fourtkacademy.user_management.dtos.responses.RoleResponseDTO
import com.fourtkacademy.user_management.mappers.RoleMapper
import com.fourtkacademy.user_management.services.RoleService
import jakarta.validation.Valid
import mu.two.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/roles")
class RoleController(
    val roleService: RoleService,
    val roleMapper: RoleMapper
){

    private val logger = KotlinLogging.logger {}
    @PostMapping
    fun create(
        @Valid @RequestBody request: RoleRequestDTO
    ): ResponseEntity<RoleResponseDTO>{
        return runCatching {
            logger.info {
                "[CREATE-ROLE]-[Controller] Starting the saved Category name:[${request.descricao}]"
            }
            ResponseEntity(
                roleService.saved(roleMapper.toRequestDTOForEntity(request)),
                HttpStatus.CREATED
            )
        }.onFailure {
            logger.error {
                "[CREATE-ROLE]-[Controller] failed"
            }
        }.onSuccess {
            logger.info {
                "[CREATE-ROLE]-[Controller] The hiring process was successfully completed"
            }
        }.getOrThrow()
    }
}