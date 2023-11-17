package com.client.ws.rasplus.service

import com.client.ws.rasplus.exception.NotFoundException
import com.client.ws.rasplus.model.User
import com.client.ws.rasplus.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    fun getAllUsers(): List<User> = repository.findAll()

    fun getUserById(id: Long): User? =
        repository.findById(id).orElse(null) ?: throw NotFoundException("user.not.found")

    fun saveUser(user: User): User = repository.save(user)

    fun deleteUser(id: Long): Unit = repository.deleteById(id)

}