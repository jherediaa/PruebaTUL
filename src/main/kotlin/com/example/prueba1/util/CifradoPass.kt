package com.example.prueba1.util

import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

class CifradoPass {

    companion object {
        fun hashString(input: String): String {
            val bytes = MessageDigest
                .getInstance("SHA-256")
                .digest(input.toByteArray())
            return DatatypeConverter.printHexBinary(bytes).toUpperCase()
        }
    }
}