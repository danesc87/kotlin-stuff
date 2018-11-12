package database

import TestUtilities
import com.nanobytes.crud.database.DBUtils
import com.nanobytes.crud.models.Career
import ninja.sakib.pultusorm.core.PultusORM
import ninja.sakib.pultusorm.core.PultusORMCondition
import ninja.sakib.pultusorm.core.enableDebugMode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

/**
 * Class that test if DBUtils works properly
 * @author Daniel Córdova A.
 */
class DBUtilsTest {

    companion object {

        @BeforeAll
        @JvmStatic
        fun setUp() {
            enableDebugMode(true)
            TestUtilities.initTestDB()

        }
    }

    @Test
    fun shouldCreateANewDBOrConnection(){
        val dbUtils: DBUtils = DBUtils
        val testingORM = PultusORM("mscDB.db", System.getProperty("user.dir"))
        dbUtils.initOrCreate()
        val ormInstance:PultusORM = dbUtils.pultusORM

        Assertions.assertEquals(
                (ormInstance to DEFAULT_BUFFER_SIZE).second,
                (testingORM to DEFAULT_BUFFER_SIZE).second
        )
    }

    @Test
    fun shouldCreateANewDBOrConnectionByProvidingNameAndPath() {
        val newDBUtils = DBUtils
        newDBUtils.initOrCreate("testDB.db", System.getProperty("user.dir"))
        val ormInstance:PultusORM = newDBUtils.pultusORM

        Assertions.assertEquals(
                (ormInstance to DEFAULT_BUFFER_SIZE).second,
                (TestUtilities.testORM to DEFAULT_BUFFER_SIZE).second
        )
    }

    @Test
    fun shouldCreateAConditionProperly() {
        val expectedCondition: PultusORMCondition = PultusORMCondition
                .Builder()
                .eq("id", 1)
                .build()
        val actualCondition: PultusORMCondition = DBUtils.buildConditionById(1)

        Assertions.assertEquals(expectedCondition.rawQuery(), actualCondition.rawQuery())
    }

    @Test
    fun shouldReturnTrueIfAPartialUpdateWasSuccessfullyApplied() {
        val result: Boolean = DBUtils.genericPartialUpdate(5, listOf("career:Electric Engineering"), Career())

        Assertions.assertTrue(result)
    }
}