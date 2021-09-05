import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.sber.qa.ScanTimeoutException
import ru.sber.qa.Scanner
import kotlin.random.Random

internal class ScannerTest {
    private var byteArr = Random.nextBytes(100)

    @Test
    fun scannerTimeExceptionTest(){
        mockkObject(Random)
        every { Random.nextLong(5000L, 15000L) } returns 10001L
        assertThrows(ScanTimeoutException::class.java, {Scanner.getScanData()})

    }
    @Test
    fun getScanDataExceptionTest() {
        mockkObject(Random)
        every { Random.nextLong(5000L, 15000L) } returns 5000L
        assertDoesNotThrow({Scanner.getScanData()})
    }

    @Test
    fun getScanDataTest() {
        mockkObject(Random)
        every { Random.nextLong(5000L, 15000L) } returns 5000L
        assertEquals(Scanner.getScanData().size, byteArr.size)
    }


}