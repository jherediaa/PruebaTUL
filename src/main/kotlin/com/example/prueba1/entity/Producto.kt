package com.example.prueba1.entity

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.springframework.lang.Nullable
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "producto")
data class Producto (
    @Column(nullable = false)
    @Nullable
    val nombreProducto: String = "",

    @Column(nullable = false)
    @Nullable
    val sku: String = "",

    @Column(nullable = false)
    @Nullable
    val descripción: String = "",

    @Column(nullable = false)
    @Nullable
    val precio: Double = 0.0,
    val descuento: Double = 0.0,
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var identificador: UUID = UUID.randomUUID(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idPk: Long = 0,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_carritodetalle")
    var carritoDetalle: CarritoDetalle? = null,

    @Column(name="Estado", columnDefinition = "varchar(2)  default 'A'", nullable = false)
    @Nullable
    var estado: String = "A",
    val stock: Number = 0.0,

){
}
