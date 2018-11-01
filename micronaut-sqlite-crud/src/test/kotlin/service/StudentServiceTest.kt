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
        private val noSchoolIdTestStudent: Student = Student()
        private val noCareerIdTestStudent: Student = Student()
        private val noPersonIdTestStudent: Student = Student()
        private val studentService: StudentService = StudentService

        @BeforeAll
        @JvmStatic
        fun setUp() {
            DBUtils.initOrCreate("testDB.db", System.getProperty("user.dir"))
            testORM = DBUtils.pultusORM
            testStudent.schoolId = 1
            testStudent.careerId = 1
            testStudent.personId = 1

            noSchoolIdTestStudent.schoolId = 5
            noSchoolIdTestStudent.careerId = 1
            noSchoolIdTestStudent.personId = 1

            noCareerIdTestStudent.schoolId = 1
            noCareerIdTestStudent.careerId = 5
            noCareerIdTestStudent.personId = 1

            noPersonIdTestStudent.schoolId = 1
            noPersonIdTestStudent.careerId = 1
            noPersonIdTestStudent.personId = 5

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

    @Test
    fun shouldReturnFalseIfASchoolNotExist() {
        val result: Boolean = studentService.saveNewStudent(noSchoolIdTestStudent)

        // Save operation must be false because no School was previously saved
        Assertions.assertFalse(result)
    }

    @Test
    fun shouldReturnFalseIfACareerNotExist() {
        val result: Boolean = studentService.saveNewStudent(noCareerIdTestStudent)

        // Save operation must be false because no Career was previously saved
        Assertions.assertFalse(result)
    }

    @Test
    fun shouldReturnFalseIfAPersonNotExist() {
        val result: Boolean = studentService.saveNewStudent(noPersonIdTestStudent)

        // Save operation must be false because no Person was previously saved
        Assertions.assertFalse(result)
    }

    @Test
    fun shouldReturnAListWithStudents() {
        val expected: List<Student> = listOf(testStudent)
        var actual: MutableList<Student> = studentService.getAllStudents()

        Assertions.assertEquals(
                expected[0].schoolId,
                actual[0].schoolId
        )

        Assertions.assertEquals(expected.size, actual.size)
    }

    @Test
    fun shouldReturnOneStudent() {
        val expectedStudent: Student = testStudent
        val student: Student = studentService.getStudentById(1)
        val actualStudent: Student = student

        Assertions.assertEquals(expectedStudent.schoolId, actualStudent.schoolId)
        Assertions.assertEquals(expectedStudent.careerId, actualStudent.careerId)
        Assertions.assertEquals(expectedStudent.personId, actualStudent.personId)
    }

    @Test
    fun throwAnExceptionIfDoesNotFoundAStudent() {
        Assertions.assertThrows(IndexOutOfBoundsException::class.java) { studentService.getStudentById(5) }
    }

    @Test
    fun shouldReturnTrueIfAFullUpdateWasSuccessfullyApplied() {
        val result: Boolean = studentService.fullUpdate(1, testStudent)

        Assertions.assertTrue(result)
    }
}