import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.sber.qa.ScanTimeoutException

internal class ScanTimeoutExceptionTest{
    @Test
    fun scanTimeExceptionTest(){
        assertEquals(ScanTimeoutException().message, "Таймаут сканирования документа")
    }
}