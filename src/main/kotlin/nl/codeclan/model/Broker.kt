package nl.codeclan.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
class Broker(
    val name: String
) {

    constructor() : this("")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @OneToOne(cascade = [(CascadeType.ALL)])
    var address: Address = Address()

    @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY, mappedBy = "broker")
    @JsonManagedReference
    val contactPersons: MutableList<BrokerContactPerson> = ArrayList()

}