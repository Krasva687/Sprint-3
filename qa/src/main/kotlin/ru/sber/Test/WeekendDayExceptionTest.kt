import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.sber.qa.WeekendDayException
import java.lang.Exception
import kotlin.test.assertFailsWith

internal class WeekendDayExceptionTest{
    @Test
    fun weekDayTest(){
        assertEquals(WeekendDayException().message, "Заказ справков в выходной день не работает")
    }
}