package com.example.prueba1.controler

import com.example.prueba1.entity.Cliente
import com.example.prueba1.entity.DataLogin
import com.example.prueba1.service.SCliente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/carritocompras")
class ClienteControler {

    @Autowired
    lateinit var Scliente : SCliente


    @GetMapping("/listCliente")
    public fun listAll(): List<Cliente> {
        return Scliente.listCliente();
    }

    @PostMapping("/login")
    public fun login(@RequestBody @Validated login :DataLogin): String? {
        return login.username?.let { login.password?.let { it1 -> Scliente.login(it, it1) } }
    }

    @PostMapping("/insertCliente")
    fun Insert(@RequestBody @Validated cliente :Cliente) : Cliente? {
        return Scliente.Insert(cliente);
    }

}