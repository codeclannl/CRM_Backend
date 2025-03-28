package nl.codeclan.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank

@Entity
class Address(
    @field:NotBlank(message = "City must not be blank")
    val city: String,

    @field:NotBlank(message = "Street name must not be blank")
    var streetName: String,

    @field:NotBlank(message = "Zipcode must not be blank")
    var zipCode: String,

    @field:NotBlank(message = "House number must not be blank")
    var houseNumber: String,
) {
    constructor() : this("", "", "", "")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
}