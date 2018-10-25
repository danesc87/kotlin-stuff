package database

import TestUtilities
import com.nanobytes.crud.database.DBUtils
import ninja.sakib.pultusorm.core.PultusORM
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

        private val dbUtils: DBUtils = DBUtils

        @BeforeAll
        @JvmStatic
        fun setUp() {
            enableDebugMode(true)
            dbUtils.initOrCreate()
            TestUtilities.initTestDB()
        }
    }

    @Test
    fun shouldCreateANewDBOrConnection(){
        val ormInstance:PultusORM = dbUtils.pultusORM
        Assertions.assertEquals(
                (ormInstance to DEFAULT_BUFFER_SIZE).second,
                (TestUtilities.testORM to DEFAULT_BUFFER_SIZE).second
        )
    }
}