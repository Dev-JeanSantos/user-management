package com.fourtkacademy.user_management.services

import com.fourtkacademy.user_management.domains.User
import com.fourtkacademy.user_management.dtos.responses.UserResponseDTO

interface UserService {
    fun saved(request: User): UserResponseDTO

}
