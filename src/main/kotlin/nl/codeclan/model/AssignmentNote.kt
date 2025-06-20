package nl.codeclan.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.util.Date

@Entity
class AssignmentNote (
    val note: String,
    val date: Date
){
    constructor() : this("", Date())

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @OneToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    var recruiter: Employee = Employee()

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "assignment_id", referencedColumnName = "id")
    @JsonBackReference
    lateinit var assignment: Assignment
}