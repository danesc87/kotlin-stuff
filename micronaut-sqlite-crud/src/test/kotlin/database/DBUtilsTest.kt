package database

import com.nanobytes.crud.database.DBUtils
import ninja.sakib.pultusorm.core.PultusORM
import ninja.sakib.pultusorm.core.enableDebugMode
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.File
import java.lang.Exception

/**
 * Class that test if DBUtils works properly
 * @author Daniel Córdova A.
 */
class DBUtilsTest {

    private val dbUtils: DBUtils = DBUtils

    companion object {

        private lateinit var testORM: PultusORM

        @BeforeAll
        @JvmStatic
        fun setUp() {
            enableDebugMode(true)
            testORM = PultusORM("mscDB.db", System.getProperty("user.dir"))
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
    fun shouldCreateANewDBOrConnection(){
        dbUtils.initOrCreate()
        val ormInstance = dbUtils.pultusORM
        Assertions.assertEquals(
                ormInstance.to(DEFAULT_BUFFER_SIZE).second,
                testORM.to(DEFAULT_BUFFER_SIZE).second
        )
    }
}