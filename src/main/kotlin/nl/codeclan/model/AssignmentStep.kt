package nl.codeclan.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
class AssignmentStep(
    val description: String,
    val status: AssignmentStatus
) {

    constructor() : this("", AssignmentStatus.OFFERED)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "assignment_id", referencedColumnName = "id")
    @JsonBackReference
    lateinit var assignment: Assignment
}