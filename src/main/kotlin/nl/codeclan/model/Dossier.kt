package nl.codeclan.model

class Dossier(
    val id: Int,
    val employee: Employee,
    val assignments: List<Assignment>,
    val chatLog: ChatLog) {
}