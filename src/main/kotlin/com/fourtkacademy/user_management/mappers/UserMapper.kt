package com.fourtkacademy.user_management.mappers

import com.fourtkacademy.user_management.domains.User
import com.fourtkacademy.user_management.dtos.requesties.UserRequestDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    fun toRequestDTOForEntity(request: UserRequestDTO): User

}
