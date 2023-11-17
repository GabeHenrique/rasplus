package com.client.ws.rasplus.controller

import com.client.ws.rasplus.model.UserType
import com.client.ws.rasplus.service.UserTypeService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "User Type")
@RestController
@RequestMapping("/user-types")
class UserTypeController(private val service: UserTypeService) {

    @Operation(
        summary = "buscar os tipos de usuários",
        description = "permite realizar a busca dos tipos de usuários cadastrados"
    )
    @GetMapping("/all")
    fun findAll(): ResponseEntity<List<UserType>> {
        val userTypes = service.getAllUserTypes()
        return ResponseEntity.ok(userTypes)
    }

    @Operation(
        summary = "buscar um tipo de usuário",
        description = "permite realizar a busca de um tipo de usuário cadastrado"
    )
    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long): ResponseEntity<UserType> {
        val userTypes = service.getUserTypeById(id)
        return if (userTypes != null) ResponseEntity.ok(userTypes) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @Operation(
        summary = "salvar um tipo de usuário",
        description = "permite realizar a inclusão ou alteração de um tipo de usuário"
    )
    @PostMapping("/save")
    fun save(@RequestBody subscriptionType: UserType): ResponseEntity<UserType> {
        val userTypes = service.saveUserType(subscriptionType)
        return ResponseEntity.ok(userTypes)
    }

    @Operation(
        summary = "excluir um tipo de usuário",
        description = "permite realizar a exclusão de um tipo de usuário"
    )
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.deleteUserType(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}