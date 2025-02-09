package com.fourtkacademy.user_management.controllers

import com.fourtkacademy.user_management.dtos.requesties.UserRequestDTO
import com.fourtkacademy.user_management.dtos.responses.UserResponseDTO
import com.fourtkacademy.user_management.mappers.UserMapper
import com.fourtkacademy.user_management.services.UserService
import jakarta.validation.Valid
import mu.two.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    val userService: UserService,
    val userMapper: UserMapper
){

    private val logger = KotlinLogging.logger {}
    @PostMapping
    fun create(
        @Valid @RequestBody request: UserRequestDTO
    ): ResponseEntity<UserResponseDTO>{
        return runCatching {
            logger.info {
                "[CREATE-USER]-[Controller] Starting the saved Category name:[${request.name}]"
            }
            ResponseEntity(
                userService.saved(userMapper.toRequestDTOForEntity(request)),
                HttpStatus.CREATED
            )
        }.onFailure {
            logger.error {
                "[CREATE-USER]-[Controller] failed"
            }
        }.onSuccess {
            logger.info {
                "[CREATE-USER]-[Controller] The hiring process was successfully completed"
            }
        }.getOrThrow()
    }
}