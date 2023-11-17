package com.client.ws.rasplus.model

import com.client.ws.rasplus.utils.YearMonthConverter
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDate
import java.time.YearMonth

@Entity
@Table(name = "user_payment_info")
data class UserPaymentInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_payment_info_id")
    var id: Long?,

    @Column(name = "card_number")
    var cardNumber: String,

    @Column(name = "card_expiration")
    @Convert(converter = YearMonthConverter::class)
    var cardExpiration: YearMonth,

    @Column(name = "card_security_code")
    var cardSecurityCode: String,

    @Column(name = "dt_payment")
    var paymentDate: LocalDate,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User
) : Serializable