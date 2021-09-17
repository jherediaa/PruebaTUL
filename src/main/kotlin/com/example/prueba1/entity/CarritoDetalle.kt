package com.example.prueba1.entity

import org.springframework.lang.Nullable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "carritodetalle")
data class CarritoDetalle(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var identificador: UUID = UUID.randomUUID(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idPk: Long = 0,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_carrito")
    var carrito: Carrito? = null,

    @OneToMany(mappedBy = "carritoDetalle", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
    var producto: List<Producto> = emptyList(),

    @Column(name="Estado", columnDefinition = "varchar(2)  default 'A'", nullable = false)
    @Nullable
    var estado: String = "A"
) {
    override fun toString(): String {
        return "{ carrito: ${carrito}}"
    }
}