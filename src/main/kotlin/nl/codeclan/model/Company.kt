package nl.codeclan.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
class Company(
    @field:NotBlank(message = "Name must not be blank")
    val name: String,

    @field:NotBlank(message = "Contact phone number must not be blank")
    val contactPersonTelephone: String,

) {

    constructor() : this("", "")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @OneToOne(cascade = [(CascadeType.ALL)])
    var address: Address = Address()

    var contactPerson: String = ""

}