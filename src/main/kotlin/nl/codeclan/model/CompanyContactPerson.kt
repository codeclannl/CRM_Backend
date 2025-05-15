package nl.codeclan.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class CompanyContactPerson : Person {
    constructor(firstName: String, lastName: String, telephoneNumber: String) : super(firstName, lastName, telephoneNumber)
    constructor() : super("", "", "")

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @JsonBackReference
    lateinit var company: Company
}