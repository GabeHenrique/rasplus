package com.client.ws.rasplus.service

import com.client.ws.rasplus.exception.NotFoundException
import com.client.ws.rasplus.model.UserPaymentInfo
import com.client.ws.rasplus.repository.UserPaymentInfoRepository
import org.springframework.stereotype.Service

@Service
class UserPaymentInfoService(private val repository: UserPaymentInfoRepository) {

    fun getAllUserPaymentInfos(): List<UserPaymentInfo> = repository.findAll()

    fun getUserPaymentInfoById(id: Long): UserPaymentInfo? =
        repository.findById(id).orElse(null) ?: throw NotFoundException("user.payment.info.not.found")

    fun saveUserPaymentInfo(userPaymentInfo: UserPaymentInfo): UserPaymentInfo = repository.save(userPaymentInfo)

    fun deleteUserPaymentInfo(id: Long): Unit = repository.deleteById(id)

    fun getUserPaymentInfoByUserId(userId: Long): UserPaymentInfo? =
        repository.findByUserId(userId) ?: throw NotFoundException("user.payment.info.not.found")
}