package nl.codeclan.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.util.*

@Entity
class Assignment(
    var creationDate: Date,
    var endDate: Date?,
    var status: AssignmentStatus,
    var description: String?,
    var title: String,
    var tariff: Double?,
    var function: String
) {

    constructor() : this(Date(), Date(), AssignmentStatus.OFFERED, "", "", 0.0, "")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @OneToOne
    var company: Company = Company()

    @OneToOne
    var broker: Broker = Broker()

    @OneToOne
    var contactPerson: BrokerContactPerson = BrokerContactPerson()

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignment")
    var notes: List<AssignmentNote> = ArrayList<AssignmentNote>()

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignment")
    var assignmentSteps: List<AssignmentStep> = ArrayList<AssignmentStep>()

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "dossier_id", referencedColumnName = "id")
    @JsonBackReference
    var dossier: Dossier? = null
}