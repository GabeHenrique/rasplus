package com.client.ws.rasplus.repository

import com.client.ws.rasplus.model.UserPaymentInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserPaymentInfoRepository : JpaRepository<UserPaymentInfo, Long> {
    fun findByUserId(userId: Long): UserPaymentInfo?
}