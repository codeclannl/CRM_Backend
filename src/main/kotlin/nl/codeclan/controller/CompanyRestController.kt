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
    fun deleteCompany(@Valid @RequestBody company: Company): Boolean {
        logger.info("Deleting Company ${company.id}")

        if (companyRepository.findById(company.id).isPresent) {
            companyRepository.deleteById(company.id)

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

    @PatchMapping("/updateCompany")
    fun updateCompany(@Valid @RequestBody company: Company): Boolean {
        logger.info("Updating Company ${company.name}")

        val update = companyRepository.updateCompany(company.name, company.contactPersonTelephone, company.address, company.contactPersonTelephone, company.id)

        return update > 0
    }


}