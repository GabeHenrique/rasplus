package com.client.ws.rasplus.repository

import com.client.ws.rasplus.model.UserType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserTypeRepository : JpaRepository<UserType, Long>