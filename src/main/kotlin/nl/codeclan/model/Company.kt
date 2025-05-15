package nl.codeclan.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
class Company(
    @field:NotBlank(message = "Name must not be blank")
    val name: String

) {

    constructor() : this("")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @OneToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    var address: Address = Address()

    @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY, mappedBy = "company")
    @JsonManagedReference
    val contactPersons: MutableList<CompanyContactPerson> = ArrayList()

}