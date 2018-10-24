package service

import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.School
import com.nanobytes.crud.service.SchoolService
import ninja.sakib.pultusorm.core.PultusORM
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.File
import java.lang.Exception

/**
 * Class that test if School Service works properly
 */
class SchoolServiceTest {

    companion object {

        private lateinit var pultusORM: PultusORM
        private val testSchool: School = School()
        private val schoolService: SchoolService = SchoolService

        @BeforeAll
        @JvmStatic
        fun setUp() {
            DBUtils.initOrCreate()
            pultusORM = DBUtils.pultusORM
            testSchool.schoolName = "Engineering School"
            pultusORM.save(testSchool)
        }

        @AfterAll
        @JvmStatic
        fun afterTest() {
            val fileNameWithPath: String = System.getProperty("user.dir").plus("mscDB.db")
            try {
                val file: File = File(fileNameWithPath)
                file.delete()
            } catch (e: Exception) {
                e.printStackTrace()
            }
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
    }
}