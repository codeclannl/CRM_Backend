package nl.codeclan.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Broker(
    val name: String,
    val contactNumber: String,
    val contactName: String) {

    constructor() : this("", "", "")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
}