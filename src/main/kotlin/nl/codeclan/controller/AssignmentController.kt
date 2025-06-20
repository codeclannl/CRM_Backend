package nl.codeclan.controller

import jakarta.validation.Valid
import nl.codeclan.model.AssignmentDTO
import nl.codeclan.service.AssignmentService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("assignment")
class AssignmentController {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var assignmentService: AssignmentService

    @PostMapping("/new")
    fun createAssignment(@Valid @RequestBody assignment: AssignmentDTO) {
        logger.info("Creating new  assignment ${assignment.title}")

        assignmentService.saveAssignment(assignment)
    }

    @DeleteMapping("/delete")
    fun deleteAssignmenty(@Valid @RequestParam id: Long): Boolean {
        logger.info("Deleting assignment ${id}")

        return assignmentService.deleteAssignment(id);
    }

    @GetMapping("/listAll")
    fun listAllAssignments(): List<AssignmentDTO> {

        return assignmentService.findAllAssignments()
    }

    @PatchMapping("/update")
    fun updateAssignment(@Valid @RequestBody updatedAssignment: AssignmentDTO): Boolean {
        logger.info("Updating assignment ${updatedAssignment.title}")

        return assignmentService.updateAssignment(updatedAssignment)
    }

}