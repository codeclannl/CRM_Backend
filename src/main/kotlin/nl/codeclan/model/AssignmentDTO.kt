package nl.codeclan.model

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

class AssignmentDTO(
    val id: Long,
    val creationDate: Date,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    val endDate: Date?,
    val status: AssignmentStatus,
    val description: String,
    val title: String,
    val tariff: Double?,
    val function: String,
    val companyId: Long,
    val brokerId: Long,
    val contactPersonId: Long,

    ) {
}