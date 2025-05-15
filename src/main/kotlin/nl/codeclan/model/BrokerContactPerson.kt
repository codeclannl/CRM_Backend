package nl.codeclan.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class BrokerContactPerson : Person {
    constructor(firstName: String, lastName: String, telephoneNumber: String) : super(firstName, lastName, telephoneNumber)
    constructor() : super("", "", "")

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "broker_id", referencedColumnName = "id")
    @JsonBackReference
    lateinit var broker: Broker

}