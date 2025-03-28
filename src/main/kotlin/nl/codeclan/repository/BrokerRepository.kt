package nl.codeclan.repository

import nl.codeclan.model.Broker
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface BrokerRepository : CrudRepository<Broker, Long> {

    @Transactional
    @Modifying
    @Query(
        """update Broker c set c.name = ?1, c.contactName = ?2, c.contactNumber = ?3
            where c.id = ?4"""
    )
    fun updateBroker(name: String, contactName: String, contactNumber: String, id: Long): Int
}