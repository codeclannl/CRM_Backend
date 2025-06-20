package nl.codeclan.repository

import nl.codeclan.model.Assignment
import org.springframework.data.repository.CrudRepository

interface AssignmentRepository : CrudRepository<Assignment, Long>