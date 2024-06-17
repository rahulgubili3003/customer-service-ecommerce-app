package com.online.store.application.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    val id: Long? = null,

    @Column(name = "building_no", nullable = false)
    val buildingNo: String,

    @Column(name = "street_1", nullable = false)
    val streetOne: String,

    @Column(name = "street_2")
    val streetTwo: String,

    @Column(name = "city", nullable = false)
    val city: String,

    @Column(name = "zipcode", nullable = false)
    val zipCode: String,

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    val createdAt: Date? = null,

    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: Date? = null,

    @Column(name = "is_deleted")
    val isDeleted: Boolean = false
)
