package com.client.ws.rasplus.model

import jakarta.persistence.*
import java.io.Serializable


@Entity
@Table(name = "user_type")
data class UserType(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_type_id")
    var id: Long?,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String
) : Serializable


//    fun toEntity(): UserType {
//        val userType = UserType();
//        BeanUtils.copyProperties(this, userType)
//        return userType
//    }
