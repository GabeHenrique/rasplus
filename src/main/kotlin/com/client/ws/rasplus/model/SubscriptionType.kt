package com.client.ws.rasplus.model

import jakarta.persistence.*
import java.io.Serializable
import java.math.BigDecimal
import java.math.BigInteger

@Entity
@Table(name = "subscriptions_type")
data class SubscriptionType(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscriptions_type_id")
    var id: Long,

    @Column(name = "name")
    var name: String,

    @Column(name = "access_months")
    var accessMonth: BigInteger,

    @Column(name = "price")
    var price: BigDecimal,

    @Column(name = "product_key")
    var productKey: String
) : Serializable
