package com.fourtkacademy.user_management.repositories

import com.fourtkacademy.user_management.domains.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Long> {

}
