package nl.codeclan

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrmBackendApplication
    fun main(args: Array<String>) {
        runApplication<CrmBackendApplication>(*args)
    }