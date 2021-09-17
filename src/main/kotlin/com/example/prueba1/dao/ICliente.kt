package com.example.prueba1.dao

import com.example.prueba1.entity.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.io.Serializable

@Repository
interface ICliente : CrudRepository<Cliente, Serializable>, PagingAndSortingRepository<Cliente, Serializable> {
    fun findByApellido(apellido: String): List<Cliente>
    fun findByCorreoAndPasswords(correo :String , passwords:String ) : Cliente
}