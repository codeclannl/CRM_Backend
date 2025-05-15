package nl.codeclan.controller

import jakarta.validation.Valid
import nl.codeclan.repository.AddressRepository
import nl.codeclan.repository.CompanyRepository
import nl.codeclan.model.Address
import nl.codeclan.model.Company
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("company")
class CompanyRestController {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Autowired
    lateinit var addressRepository: AddressRepository

    @PostMapping("/new")
    fun createCompany(@Valid @RequestBody company: Company): String {
        logger.info("Creating Company ${company.name}")

        val savedCompany = companyRepository.save(company)

        return "Company saved with id " + savedCompany.id.toString()
    }

    @DeleteMapping("/delete")
    fun deleteCompany(@Valid @RequestParam id: Long): Boolean {
        logger.info("Deleting Company ${id}")

        if (companyRepository.findById(id).isPresent) {
            companyRepository.deleteById(id)

            return true
        }

        return false
    }

    @GetMapping("/listAll")
    fun listAllCompanies(): List<Company> {

        val all = companyRepository.findAll()

        return all.toList()
    }

    @GetMapping("/listAddresses")
    fun listAllAddresses(): List<Address> {

        val all = addressRepository.findAll()

        return all.toList()
    }

    @PatchMapping("/update")
    fun updateCompany(@Valid @RequestBody updatedCompany: Company): Boolean {
        logger.info("Updating Company ${updatedCompany.name}")

        if (companyRepository.findById(updatedCompany.id).isPresent) {
            companyRepository.save(updatedCompany)

            return true
        }

        return false
    }


}