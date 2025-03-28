package nl.codeclan.model

import jakarta.persistence.*

@Entity
class Broker(
    val name: String,
    val contactNumber: String,
    val contactName: String) {

    constructor() : this("", "", "")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @OneToOne(cascade = [(CascadeType.ALL)])
    var address: Address = Address()
}