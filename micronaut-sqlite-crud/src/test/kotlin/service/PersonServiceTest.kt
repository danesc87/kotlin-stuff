package service

import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.Person
import com.nanobytes.crud.service.PersonService
import ninja.sakib.pultusorm.core.PultusORM
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

/**
 * Class that test if Person Service works properly
 * @author Daniel Córdova A.
 */
class PersonServiceTest {

    companion object {

        private lateinit var testORM: PultusORM
        private val testPerson: Person = Person()
        private val personService: PersonService = PersonService

        @BeforeAll
        @JvmStatic
        fun setUp() {
            DBUtils.initOrCreate("testDB.db", System.getProperty("user.dir"))
            testORM = DBUtils.pultusORM
            testPerson.dni = "0123456789-A1"
            testPerson.name = "John"
            testPerson.lastName = "Doe"
            testORM.save(testPerson)
        }
    }

    @Test
    fun shouldReturnTrueWhileSaveNewPerson() {
        val result: Boolean = personService.saveNewPerson(testPerson)

        // Save operation must be false because Person DNI is Unique
        // and was saved on setUp() function
        Assertions.assertFalse(result)
    }

    @Test
    fun shouldReturnAPersonList() {
        val expected: List<Person> = listOf(testPerson)
        var actual: MutableList<Person> = personService.getAllPersons()

        Assertions.assertEquals(
                expected[0].dni,
                actual[0].dni
        )

        Assertions.assertEquals(expected.size, actual.size)
    }

    @Test
    fun shouldReturnAPerson() {
        val expectedDNI: String = testPerson.dni
        val person: Person = personService.getPersonById(1)
        val actualDNI: String = person.dni

        Assertions.assertEquals(expectedDNI, actualDNI)
    }
}