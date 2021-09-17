package com.example.prueba1.entity

import org.springframework.lang.Nullable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "carrito")
data class Carrito(
    var detalle: String = "",

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var identificador: UUID = UUID.randomUUID(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idPk: Long = 0,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente")
    var cliente: Cliente? = null,

    @OneToMany(mappedBy = "carrito", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
    var carritoDetalle: List<CarritoDetalle> = emptyList(),

    @Column(name="Estado", columnDefinition = "varchar(2)  default 'A'", nullable = false)
    @Nullable
    var estado: String = "A"

) {
    override fun toString(): String {
        return "{detalle: ${this.detalle}, cliente: ${cliente}}"
    }
}