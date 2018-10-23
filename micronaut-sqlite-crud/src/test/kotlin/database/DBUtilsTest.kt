package database

import com.nanobytes.crud.database.DBUtils
import ninja.sakib.pultusorm.core.PultusORM
import ninja.sakib.pultusorm.core.enableDebugMode
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Class that test if DBUtils works properly
 * @author Daniel Córdova A.
 */
class DBUtilsTest {
    private val dbUtils: DBUtils = DBUtils
    private lateinit var testORM: PultusORM

    @Before
    fun setUp() {
        enableDebugMode(true)
        testORM = PultusORM("mscDB.db", System.getProperty("user.dir"))
    }

    @Test
    fun shouldCreateANewDBOrConnection(){
        dbUtils.initOrCreateDB()
        val ormInstance = dbUtils.pultusORM!!
        Assert.assertEquals(
                ormInstance.to(DEFAULT_BUFFER_SIZE).second,
                testORM.to(DEFAULT_BUFFER_SIZE).second
        )
    }
}