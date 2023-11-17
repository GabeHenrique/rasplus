package com.client.ws.rasplus.service

import com.client.ws.rasplus.exception.NotFoundException
import com.client.ws.rasplus.model.UserType
import com.client.ws.rasplus.repository.UserTypeRepository
import org.springframework.stereotype.Service

@Service
class UserTypeService(private val repository: UserTypeRepository) {

    fun getAllUserTypes(): List<UserType> = repository.findAll()

    fun getUserTypeById(id: Long): UserType? =
        repository.findById(id).orElse(null) ?: throw NotFoundException("user.type.not.found")

    fun saveUserType(userType: UserType): UserType = repository.save(userType)

    fun deleteUserType(id: Long): Unit = repository.deleteById(id)
}