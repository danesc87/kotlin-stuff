package service

import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.Student
import com.nanobytes.crud.service.StudentService
import ninja.sakib.pultusorm.core.PultusORM
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

/**
 * Class that test if Student Service works properly
 * @author Daniel Córdova A.
 */
class StudentServiceTest {

    companion object {

        private lateinit var testORM: PultusORM
        private val testStudent: Student = Student()
        private val studentService: StudentService = StudentService

        @BeforeAll
        @JvmStatic
        fun setUp() {
            DBUtils.initOrCreate("testDB.db", System.getProperty("user.dir"))
            testORM = DBUtils.pultusORM
            testStudent.schoolId = 1
            testStudent.careerId = 1
            testStudent.personId = 1
            testORM.save(testStudent)
        }
    }

    @Test
    fun shouldReturnFalseIfAStudentWasSavedPreviously() {
        val result: Boolean = studentService.saveNewStudent(testStudent)

        // Save operation must be false because PersonId is Unique
        // and was saved on setUp() function
        Assertions.assertFalse(result)
    }
}