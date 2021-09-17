package com.example.prueba1.dao

import com.example.prueba1.entity.Carrito
import com.example.prueba1.entity.CarritoDetalle
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.io.Serializable

@Repository
interface ICarritoDetalle : CrudRepository<CarritoDetalle, Serializable>, PagingAndSortingRepository<CarritoDetalle, Serializable> {
    fun findByCarrito(carrito: Carrito): List<CarritoDetalle>
}