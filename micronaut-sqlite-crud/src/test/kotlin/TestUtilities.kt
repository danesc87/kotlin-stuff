import ninja.sakib.pultusorm.core.PultusORM
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

/**
 * Singleton that has some utilities to make UnitTests easier
 * @author Daniel Córdova A.
 */
object TestUtilities {

    private val LOGGER: Logger = LoggerFactory.getLogger(TestUtilities::class.java)
    private val dbPath: String = System.getProperty("user.dir")
    private const val dbName: String = "testDB.db"
    lateinit var testORM: PultusORM

    fun initTestDB() {
        testORM = PultusORM(dbName, dbPath)
    }

    fun deleteDBFile() {
        val fileNameWithPath: String = dbPath.plus("/").plus(dbName)
        deleteFile(fileNameWithPath)
    }

    private fun deleteFile(fileNameWithPath: String) {
        try {
            val file = File(fileNameWithPath)
            if (file.delete()) {
                LOGGER.info("File $dbName successfully deleted!")
            } else {
                LOGGER.error("Couldn't delete $dbName file!")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
