package nl.codeclan.controller

import jakarta.validation.Valid
import nl.codeclan.repository.AddressRepository
import nl.codeclan.repository.BrokerRepository
import nl.codeclan.model.Address
import nl.codeclan.model.Broker
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("broker")
class BrokerRestController {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var brokerRepository: BrokerRepository

    @Autowired
    lateinit var addressRepository: AddressRepository

    @PostMapping("/new")
    fun createBroker(@Valid @RequestBody broker: Broker): String {
        logger.info("Creating Broker ${broker.name}")
        val savedBroker = brokerRepository.save(broker)

        return "Broker saved with id " + savedBroker.id.toString()
    }

    @DeleteMapping("/delete")
    fun deleteBroker(@Valid @RequestParam id: Long): Boolean {
        logger.info("Deleting Broker with id ${id}")

        if (brokerRepository.findById(id).isPresent) {
            brokerRepository.deleteById(id)

            return true
        }

        return false
    }

    @GetMapping("/listAll")
    fun listAllCompanies(): List<Broker> {

        val all = brokerRepository.findAll()

        return all.toList()
    }

    @GetMapping("/listAddresses")
    fun listAllAddresses(): List<Address> {

        val all = addressRepository.findAll()

        return all.toList()
    }

    @PatchMapping("/update")
    fun updateBroker(@Valid @RequestBody broker: Broker): Boolean {
        logger.info("Updating Broker ${broker.name}")

        brokerRepository.save(broker)

        return true
    }


}