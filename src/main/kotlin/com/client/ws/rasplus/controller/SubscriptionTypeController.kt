package com.client.ws.rasplus.controller

import com.client.ws.rasplus.model.SubscriptionType
import com.client.ws.rasplus.service.SubscriptionTypeService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Subscription Type")
@RestController
@RequestMapping("/subscription-types")
class SubscriptionTypeController(private val service: SubscriptionTypeService) {

    @Operation(
        summary = "buscar os tipos de subscrição",
        description = "permite realizar a busca dos tipos de subscrição cadastrados"
    )
    @GetMapping("/all")
    fun findAll(): ResponseEntity<List<SubscriptionType>> {
        val subscriptionTypes = service.getAllSubscriptionTypes()
        return ResponseEntity.ok(subscriptionTypes)
    }

    @Operation(
        summary = "buscar um tipo de subscrição",
        description = "permite realizar a busca de um tipo de subscrição cadastrado"
    )
    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long): ResponseEntity<SubscriptionType> {
        val subscriptionType = service.getSubscriptionTypeById(id)
        return if (subscriptionType != null) ResponseEntity.ok(subscriptionType) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @Operation(
        summary = "salvar um tipo de subscrição",
        description = "permite realizar a inclusão ou alteração de um tipo de subscrição"
    )
    @PostMapping("/save")
    fun save(@RequestBody subscriptionType: SubscriptionType): ResponseEntity<SubscriptionType> {
        val savedSubscriptionType = service.saveSubscriptionType(subscriptionType)
        return ResponseEntity.ok(savedSubscriptionType)
    }

    @Operation(
        summary = "excluir um tipo de subscrição",
        description = "permite realizar a exclusão de um tipo de subscrição"
    )
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.deleteSubscriptionType(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}