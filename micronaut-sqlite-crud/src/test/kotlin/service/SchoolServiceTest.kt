package service

import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.School
import ninja.sakib.pultusorm.core.PultusORM
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Class that test if School Service works properly
 */
class SchoolServiceTest {

    private lateinit var pultusORM: PultusORM
    private val school: School = School()

    @Before
    fun setUp() {
        DBUtils.initOrCreate()
        pultusORM = DBUtils.pultusORM
        school.schoolName = "Test"
    }

    @Test
    fun shouldReturnTrueWhileSaveNewSchool() {
        val result: Boolean = pultusORM.save(school)
        Assert.assertTrue(result)
    }
}