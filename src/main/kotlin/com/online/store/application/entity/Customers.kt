package com.online.store.application.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
data class Customers(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false, nullable = false)
    val id: Long? = null,

    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First Name cannot be Blank. Must Contain at least one non whitespace char")
    val firstName: String,

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last Name cannot be Blank. Must Contain at least one non whitespace char")
    val lastName: String,

    @Column(name = "email", unique = true, nullable = false)
    @NotBlank(message = "Email must not be empty")
    val email: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id")
    val address: Address,

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    val createdAt: Date? = null,

    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: Date? = null,

    @Column(name = "is_deleted")
    val isDeleted: Boolean = false
)
