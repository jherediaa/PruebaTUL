package com.example.prueba1.entity

import org.springframework.lang.Nullable
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "cliente")

data class Cliente(
    @Column(unique=true)
    val dni: Long = 0,
    val nombre: String = "",
    val apellido: String = "",
    val fechaNac: LocalDate? = null,
    val fechaUpdate: LocalDate? = null,
    val fechaDelete: LocalDate? = null,
    @Nullable
    @Column(nullable = false)
    val fechaInsert: LocalDate? = null,
    val userUpdate: String? = null,
    val userDelete: String? = null,
    @Nullable
    @Column(nullable = false)
    val userInsert: String? = null,
    @OneToMany(mappedBy = "cliente", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
    var carrito: List<Carrito> = emptyList(),

    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Nullable
//    @Column(nullable = false)
    var identificador: UUID = UUID.randomUUID(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idPk: Long = 0,

    @Column(name = "correo", nullable = false, columnDefinition = "varchar(1000)", unique=true)
    @Nullable
    var correo: String? = null,

    @Column(name = "passwords", nullable = false, columnDefinition = "varchar(2000)")
    @Nullable
    var passwords: String? = null,

    @Column(name="Estado", columnDefinition = "varchar(2)  default 'A'", nullable = false)
    @Nullable
    var estado: String = "A",

) {

    override fun toString(): String {
        return "{nombre: ${this.nombre}, carrito: ${carrito.map { it }}}";
    }
}