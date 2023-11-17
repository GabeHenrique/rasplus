package com.client.ws.rasplus.controller

import com.client.ws.rasplus.model.UserPaymentInfo
import com.client.ws.rasplus.service.UserPaymentInfoService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "User Payment Info")
@RestController
@RequestMapping("/user-payment-info")
class UserPaymentInfoController(private val service: UserPaymentInfoService){

    @Operation(
        summary = "buscar as informações de pagamento dos usuários",
        description = "permite realizar a busca das informações de pagamento dos usuários cadastrados"
    )
    @GetMapping("/all")
    fun findAll(): ResponseEntity<List<UserPaymentInfo>> {
        val users = service.getAllUserPaymentInfos()
        return ResponseEntity.ok(users)
    }

    @Operation(
        summary = "buscar uma informação de pagamento de usuário",
        description = "permite realizar a busca de uma informação de pagamento de usuário cadastrado"
    )
    @GetMapping("/{userId}")
    fun findOne(@PathVariable userId: Long): ResponseEntity<UserPaymentInfo> {
        val user = service.getUserPaymentInfoByUserId(userId)
        return if (user != null) ResponseEntity.ok(user) else ResponseEntity.notFound().build()
    }


}