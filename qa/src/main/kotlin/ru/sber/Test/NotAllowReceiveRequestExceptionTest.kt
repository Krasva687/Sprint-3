import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith
import ru.sber.qa.NotAllowReceiveRequestException as NotAllowReceiveRequestException

internal class NotAllowReceiveRequestExceptionTest{
    @Test
    fun notAllowRecieveExceptionTest(){

        assertEquals(NotAllowReceiveRequestException().message, "Не разрешено принять запрос на справку")
    }
}