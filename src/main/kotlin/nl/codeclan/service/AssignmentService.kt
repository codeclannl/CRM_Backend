package nl.codeclan.service

import nl.codeclan.model.Assignment
import nl.codeclan.model.AssignmentDTO
import nl.codeclan.model.AssignmentStatus
import nl.codeclan.repository.AssignmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.Date

@Component
class AssignmentService {
    @Autowired
    lateinit var assignmentRepository: AssignmentRepository

    fun saveAssignment(assignmentDTO: AssignmentDTO) {
        val assignment = mapFromDTO(assignmentDTO)

        assignmentRepository.save(assignment)
    }

    fun deleteAssignment(id: Long): Boolean {
        if ( assignmentRepository.findById(id).isPresent) {
            assignmentRepository.deleteById(id)

            return true
        }

        return false
    }

    fun findAllAssignments(): List<AssignmentDTO> {
        val allAssignments =  assignmentRepository.findAll()

        return allAssignments.toList().stream().map { assignment -> mapToDTO(assignment) }.toList()

    }

    private fun mapFromDTO(assignmentDTO: AssignmentDTO): Assignment {
        val assignment = Assignment()
        assignment.id = assignmentDTO.id
        assignment.broker.id = assignmentDTO.brokerId
        assignment.company.id = assignmentDTO.companyId
        assignment.contactPerson.id = assignmentDTO.contactPersonId
        assignment.creationDate = assignmentDTO.creationDate
        assignment.description = assignmentDTO.description
        assignment.endDate = assignmentDTO.endDate
        assignment.function = assignmentDTO.function
        assignment.status = assignmentDTO.status
        assignment.tariff = assignmentDTO.tariff
        assignment.title = assignmentDTO.title
        return assignment
    }

    private fun mapToDTO(assignment: Assignment): AssignmentDTO {
        return AssignmentDTO(0, Date(), Date(),AssignmentStatus.OFFERED, "", "", 0.0, "", 0, 0, 0 )
    }

    fun updateAssignment(updatedAssignment: AssignmentDTO): Boolean {
        if ( assignmentRepository.findById(updatedAssignment.id).isPresent) {
            val assignment = mapFromDTO(updatedAssignment)
            assignmentRepository.save(assignment)

            return true
        }

        return false
    }

}