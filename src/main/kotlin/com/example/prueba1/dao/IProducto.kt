package com.example.prueba1.dao

import com.example.prueba1.entity.Producto
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.io.Serializable

@Repository
interface IProducto : CrudRepository<Producto, Serializable>, PagingAndSortingRepository<Producto, Serializable> {
    fun findBySku(sku: String): Producto
    fun findByNombreProducto(nombreProducto: String ) : Producto
}