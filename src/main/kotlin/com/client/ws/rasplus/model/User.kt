package com.client.ws.rasplus.model

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "users_id")
    var id: Long?,

    @Column(name = "name")
    var name: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "phone")
    var phone: String,

    @Column(name = "cpf")
    var cpf: String,

    @Column(name = "dt_subscription")
    var subscriptionDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "dt_expiration")
    var expirationDate: LocalDateTime?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_type_id")
    var userType: UserType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriptions_type_id")
    var subscriptionType: SubscriptionType
) : Serializable