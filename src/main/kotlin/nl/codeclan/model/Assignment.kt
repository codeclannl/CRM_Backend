package nl.codeclan.model

import org.springframework.context.annotation.Description

class Assignment(
    val id: Int,
    val company: Company,
    val broker: Broker,
    val status: AssignmentStatus,
    val description: String,
    val title: String,
    val tariff: Double,
    val assignmentSteps: List<AssignmentStep>) {
}