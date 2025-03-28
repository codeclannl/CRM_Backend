package nl.codeclan.repository

import nl.codeclan.model.Address
import nl.codeclan.model.Company
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface CompanyRepository : CrudRepository<Company, Long> {

    @Transactional
    @Modifying
    @Query(
        """update Company c set c.name = ?1, c.contactPersonTelephone = ?2, c.address = ?3, c.contactPerson = ?4
            where c.id = ?5"""
    )
    fun updateCompany(
        name: String,
        contactPersonTelephone: String,
        address: Address,
        contactPerson: String,
        id: Long
    ): Int
}