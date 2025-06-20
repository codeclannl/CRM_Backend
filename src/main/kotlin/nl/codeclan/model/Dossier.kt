package nl.codeclan.model

import jakarta.persistence.*

@Entity
class Dossier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @OneToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    var employee: Employee = Employee()

    @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY, mappedBy = "dossier")
    var assignments: List<Assignment> = ArrayList<Assignment>()

    @OneToOne(cascade = [(CascadeType.ALL)])
    @JoinColumn(name = "chatlog_id", referencedColumnName = "id")
    var chatLog: ChatLog = ChatLog()
}