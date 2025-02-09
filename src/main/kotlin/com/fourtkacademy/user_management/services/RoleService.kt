package com.fourtkacademy.user_management.services

import com.fourtkacademy.user_management.domains.Role
import com.fourtkacademy.user_management.domains.User
import com.fourtkacademy.user_management.dtos.responses.RoleResponseDTO
import com.fourtkacademy.user_management.dtos.responses.UserResponseDTO

interface RoleService {
    fun saved(request: Role): RoleResponseDTO

}
