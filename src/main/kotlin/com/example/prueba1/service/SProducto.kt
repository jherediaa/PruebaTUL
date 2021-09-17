package com.example.prueba1.service


import com.example.prueba1.dao.IProducto
import com.example.prueba1.entity.Producto
import com.example.prueba1.util.CifradoPass
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.stream.Collectors

@Service
class SProducto {

    @Autowired
    lateinit var Iproducto : IProducto

    fun listProducto(): List<Producto>{
        return Iproducto.findAll().toList().stream().filter{p -> p.estado == "A"}.collect(Collectors.toList())
    }

    fun Insert (producto: Producto): Producto?{
        try {
            return Iproducto.save(producto)
        } catch (e : Exception) {
            return null
        }
    }

}