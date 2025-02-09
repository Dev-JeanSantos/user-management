package com.fourtkacademy.user_management.services.impl

import com.fourtkacademy.user_management.domains.User
import com.fourtkacademy.user_management.dtos.responses.UserResponseDTO
import com.fourtkacademy.user_management.repositories.UserRepository
import com.fourtkacademy.user_management.services.UserService
import mu.two.KotlinLogging
import org.springframework.stereotype.Service

@Service
class IUserService(
    val userRepository: UserRepository,
) : UserService {

    private val logger = KotlinLogging.logger {}
    override fun saved(request: User): UserResponseDTO {
        logger.info { "[CREATE-USER]-[Service] Starting create user " +
                "User Name:[${request.name}]"}

        userRepository.save(request)
        return UserResponseDTO(message = "Category created successfully")
    }


}