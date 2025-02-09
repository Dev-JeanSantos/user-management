package com.fourtkacademy.user_management.services.impl

import com.fourtkacademy.user_management.domains.Role
import com.fourtkacademy.user_management.dtos.responses.RoleResponseDTO
import com.fourtkacademy.user_management.dtos.responses.UserResponseDTO
import com.fourtkacademy.user_management.repositories.RoleRepository
import com.fourtkacademy.user_management.services.RoleService
import mu.two.KotlinLogging
import org.springframework.stereotype.Service

@Service
class IUserService(
    val roleRepository: RoleRepository
) : RoleService {

    private val logger = KotlinLogging.logger {}

    override fun saved(request: Role): RoleResponseDTO {
        logger.info { "[CREATE-ROLE]-[Service] Starting create role " +
                "Role Name:[${request.name}]"}

        roleRepository.save(request)
        return RoleResponseDTO(message = "Category created successfully")
    }


}