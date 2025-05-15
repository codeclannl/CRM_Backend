package nl.codeclan.repository

import nl.codeclan.model.Broker
import org.springframework.data.repository.CrudRepository

interface BrokerRepository : CrudRepository<Broker, Long>