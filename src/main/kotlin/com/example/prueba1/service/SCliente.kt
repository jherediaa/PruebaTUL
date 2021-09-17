package com.example.prueba1.service

import com.example.prueba1.dao.ICliente
import com.example.prueba1.entity.Cliente
import com.example.prueba1.util.CifradoPass
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*
import java.util.stream.Collectors

@Service
class SCliente {

    @Autowired
    lateinit var Icliente : ICliente

    fun listCliente(): List<Cliente>{
       return Icliente.findAll().toList().stream().filter{c -> c.estado == "A"}.collect(Collectors.toList())
    }

    fun login(user:String, pass: String): String{
        if (Icliente.findByCorreoAndPasswords(user, CifradoPass.hashString(pass))!= null){

        }
         return Icliente.findByCorreoAndPasswords(user, CifradoPass.hashString(pass) ).correo.toString()
    }


    fun Insert (cliente: Cliente):Cliente ?{
        try {
            cliente.passwords = cliente.passwords?.let { CifradoPass.hashString(it) }
            return Icliente.save(cliente)
        } catch (e : Exception) {
           return null
        }
    }
}