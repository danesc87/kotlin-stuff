package service

import TestUtilities
import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.School
import com.nanobytes.crud.service.SchoolService
import ninja.sakib.pultusorm.core.PultusORM
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

/**
 * Class that test if School Service works properly
 * @author Daniel Córdova A.
 */
class SchoolServiceTest {

    companion object {

        private lateinit var testORM: PultusORM
        private val testSchool: School = School()
        private val schoolService: SchoolService = SchoolService

        @BeforeAll
        @JvmStatic
        fun setUp() {
            DBUtils.initOrCreate("testDB.db", System.getProperty("user.dir"))
            testORM = DBUtils.pultusORM
            testSchool.schoolName = "Engineering School"
            testORM.save(testSchool)
        }

        @AfterAll
        @JvmStatic
        fun afterTest() {
            TestUtilities.deleteDBFile()
        }
    }

    @Test
    fun shouldReturnTrueWhileSaveNewSchool() {
        val result: Boolean = schoolService.saveNewSchool(testSchool)

        // Save operation must be false because School Name is Unique
        // and was saved on setUp() function
        Assertions.assertFalse(result)
    }

    @Test
    fun shouldReturnAListWithSchoolNames() {
        val expected: List<School> = listOf(testSchool)
        var actual: MutableList<School> = schoolService.getAllSchools()

        Assertions.assertEquals(
                expected.get(0).schoolName,
                actual.get(0).schoolName
        )

        Assertions.assertEquals(expected.size, actual.size)
    }

    @Test
    fun shouldReturnASchool() {
        val expectedSchoolName: String = testSchool.schoolName
        val school: School = schoolService.getSchoolById(1)
        val actualSchoolName: String = school.schoolName

        Assertions.assertEquals(expectedSchoolName, actualSchoolName)
    }
}