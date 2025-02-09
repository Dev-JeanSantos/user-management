package com.fourtkacademy.user_management.mappers

import com.fourtkacademy.user_management.domains.Role
import com.fourtkacademy.user_management.dtos.requesties.RoleRequestDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface RoleMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    fun toRequestDTOForEntity(request: RoleRequestDTO): Role

}
