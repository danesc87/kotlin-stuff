package service

import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.Career
import com.nanobytes.crud.service.CareerService
import ninja.sakib.pultusorm.core.PultusORM
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

/**
 * Class that test if Career Service works properly
 * @author Daniel Córdova A.
 */
class CareerServiceTest {

    companion object {

        private lateinit var testORM: PultusORM
        private val testCareer: Career = Career()
        private val noSchoolTestCareer: Career = Career()
        private val careerService: CareerService = CareerService

        @BeforeAll
        @JvmStatic
        fun setUp() {
            DBUtils.initOrCreate("testDB.db", System.getProperty("user.dir"))
            testORM = DBUtils.pultusORM
            testCareer.schoolId = 1
            testCareer.career = "Computer Science"
            noSchoolTestCareer.schoolId = 5
            noSchoolTestCareer.career = "Testing Career"
            testORM.save(testCareer)
        }
    }

    @Test
    fun shouldReturnFalseIfACareerWasSavedPreviously() {
        val result: Boolean = careerService.saveNewCareer(testCareer)

        // Save operation must be false because Career Name is Unique
        // and was saved on setUp() function
        Assertions.assertFalse(result)
    }

    @Test
    fun shouldReturnFalseIfASchoolNotExist() {
        val result: Boolean = careerService.saveNewCareer(noSchoolTestCareer)

        // Save operation must be false because no School Name was previously saved
        Assertions.assertFalse(result)
    }

    @Test
    fun shouldReturnAListWithSchoolNames() {
        val expected: List<Career> = listOf(testCareer)
        var actual: MutableList<Career> = careerService.getAllCareers()

        Assertions.assertEquals(
                expected[0].career,
                actual[0].career
        )

        Assertions.assertEquals(expected.size, actual.size)
    }
}