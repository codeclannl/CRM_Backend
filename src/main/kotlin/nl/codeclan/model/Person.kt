package nl.codeclan.model

import jakarta.persistence.*
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
open class Person (
    @field:NotBlank(message = "First name must not be blank")
    open val firstName: String,

    @field:NotBlank(message = "Last name must not be blank")
    open val lastName: String,

    @field:NotBlank(message = "Telephone number must not be blank")
    open val telephoneNumber: String
    ) {

        constructor() : this("", "", "")

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        open var id: Long = 0

    }