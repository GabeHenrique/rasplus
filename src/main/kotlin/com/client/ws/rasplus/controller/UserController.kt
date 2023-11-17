package com.client.ws.rasplus.controller

import com.client.ws.rasplus.model.User
import com.client.ws.rasplus.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "User")
@RestController
@RequestMapping("/users")
class UserController(private val service: UserService) {

    @Operation(
        summary = "buscar os usuários",
        description = "permite realizar a busca dos usuários cadastrados"
    )
    @GetMapping("/all")
    fun findAll(): ResponseEntity<List<User>> {
        val users = service.getAllUsers()
        return ResponseEntity.ok(users)
    }

    @Operation(
        summary = "buscar um usuário",
        description = "permite realizar a busca de um usuário cadastrado"
    )
    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long): ResponseEntity<User> {
        val user = service.getUserById(id)
        return if (user != null) ResponseEntity.ok(user) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @Operation(
        summary = "salvar um usuário",
        description = "permite realizar a inclusão ou alteração de um usuário"
    )
    @PostMapping("/save")
    fun save(@RequestBody user: User): ResponseEntity<User> {
        val savedUser = service.saveUser(user)
        return ResponseEntity.ok(savedUser)
    }

    @Operation(
        summary = "excluir um usuário",
        description = "permite realizar a exclusão de um usuário"
    )
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.deleteUser(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}