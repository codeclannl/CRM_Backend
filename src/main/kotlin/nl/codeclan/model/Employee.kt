package nl.codeclan.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

@Entity
class Employee(
    @field:NotBlank(message = "First name must not be blank")
    val firstName: String,

    @field:NotBlank(message = "Last name must not be blank")
    val lastName: String,

    @field:Min( value = 1, message = "Employee number must not be blank")
    val employeeNumber: Int,

    val recruiter: Boolean
) {

    constructor() : this("", "", 0, false)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
}