package nl.codeclan.controller

import jakarta.validation.Valid
import nl.codeclan.repository.AddressRepository
import nl.codeclan.repository.CompanyRepository
import nl.codeclan.model.Address
import nl.codeclan.model.Company
import nl.codeclan.model.Employee
import nl.codeclan.repository.EmployeeRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("employee")
class EmployeeRestController {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var employeeRepository: EmployeeRepository

    @PostMapping("/new")
    fun createEmployee(@Valid @RequestBody employee: Employee): String {
        logger.info("Creating Employee ${employee.firstName} ${employee.lastName}}")

        val savedEmployee = employeeRepository.save(employee)

        return "Employee saved with id " + savedEmployee.id.toString()
    }

    @DeleteMapping("/delete")
    fun deleteCompany(@Valid @RequestParam id: Long): Boolean {
        logger.info("Deleting employee ${id}")

        if (employeeRepository.findById(id).isPresent) {
            employeeRepository.deleteById(id)

            return true
        }

        return false
    }

    @GetMapping("/listAll")
    fun listAllCompanies(): List<Employee> {

        val all = employeeRepository.findAll()

        return all.toList()
    }

    @PatchMapping("/update")
    fun updateCompany(@Valid @RequestBody employee: Employee): Boolean {
        logger.info("Updating employee ${employee.firstName} ${employee.lastName}}}")

        if (employeeRepository.findById(employee.id).isPresent) {
            employeeRepository.save(employee)

            return true
        }

        return false
    }


}