package com.example.prueba1.dao

import com.example.prueba1.entity.Carrito
import com.example.prueba1.entity.Cliente
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.io.Serializable

@Repository
interface ICarrito : CrudRepository<Carrito, Serializable>, PagingAndSortingRepository<Carrito, Serializable> {
    fun findByIdentificador(identificador: String): Carrito
    fun findByIdPk(idPk: Long): Carrito
    fun findByCliente(cliente: Cliente): List<Carrito>
}