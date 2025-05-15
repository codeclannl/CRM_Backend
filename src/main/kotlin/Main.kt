import com.fasterxml.jackson.databind.ObjectMapper
import nl.codeclan.model.*

fun main(args : Array<String>) {
    var company: Company = Company("TestCompany")
    company.address = Address()

    val contactPerson = CompanyContactPerson("firstName", "lastname", "123456789")
    contactPerson.company = company

    val contactPerson2 = CompanyContactPerson("firstName2", "lastname2", "987654321")
    contactPerson2.company = company

    company.contactPersons.add(contactPerson)
    company.contactPersons.add(contactPerson2)

    val json = ObjectMapper().writeValueAsString(company)

    println(json)

    val broker: Broker = Broker("TestBroker")
    broker.address = Address("Eindhoven", "Kennedylaan", "5622EK", "17")

    val brokerContactPerson = BrokerContactPerson("broker_firstName", "broker_lastname", "66666666")
    brokerContactPerson.broker = broker

    val brokerContactPerson2 = BrokerContactPerson("broker_firstName2", "broker_lastname2", "777777777")
    brokerContactPerson2.broker = broker

    broker.contactPersons.add(brokerContactPerson)
    broker.contactPersons.add(brokerContactPerson2)

    val json2 = ObjectMapper().writeValueAsString(broker)

    println(json2)

    val employee: Employee = Employee("Klaas", "Vaak", 1256, true)
    val json3 = ObjectMapper().writeValueAsString(employee)

    println(json3)
}
