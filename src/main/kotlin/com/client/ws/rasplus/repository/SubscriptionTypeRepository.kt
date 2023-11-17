package com.client.ws.rasplus.repository

import com.client.ws.rasplus.model.SubscriptionType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubscriptionTypeRepository : JpaRepository<SubscriptionType, Long>