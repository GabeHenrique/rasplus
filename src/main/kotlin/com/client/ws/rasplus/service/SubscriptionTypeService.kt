package com.client.ws.rasplus.service

import com.client.ws.rasplus.exception.NotFoundException
import com.client.ws.rasplus.model.SubscriptionType
import com.client.ws.rasplus.repository.SubscriptionTypeRepository
import org.springframework.stereotype.Service

@Service
class SubscriptionTypeService(private val repository: SubscriptionTypeRepository) {

    fun getAllSubscriptionTypes(): List<SubscriptionType> = repository.findAll()

    fun getSubscriptionTypeById(id: Long): SubscriptionType? = repository.findById(id).orElse(null)?: throw NotFoundException("subscription.type.not.found")

    fun saveSubscriptionType(subscriptionType: SubscriptionType): SubscriptionType = repository.save(subscriptionType)

    fun deleteSubscriptionType(id: Long): Unit = repository.deleteById(id)
}