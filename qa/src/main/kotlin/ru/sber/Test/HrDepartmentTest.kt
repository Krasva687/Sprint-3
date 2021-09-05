import io.mockk.mockk
import io.mockk.mockkClass
import io.mockk.mockkConstructor
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import ru.sber.qa.Certificate
import ru.sber.qa.CertificateRequest
import ru.sber.qa.CertificateType
import ru.sber.qa.HrDepartment
import java.time.Clock
import java.time.LocalDateTime
import java.util.*
import kotlin.test.assertFailsWith

internal class HrDepartmentTest {
    var clock  = LocalDateTime.now(Clock.systemUTC()).dayOfWeek
    val incomeBox: LinkedList<CertificateRequest> = LinkedList()
    val outcomeOutcome: LinkedList<Certificate> = LinkedList()
    //var isAllow = ru.sber.qa.HrDepartment.receiveRequest(CertificateRequest(10L, CertificateType.NDFL))
    //var hrDepartment  = mockk<HrDepartment>(


    var certificateRequest = mockk<CertificateRequest>()


    @BeforeEach
    fun setUp() {
        certificateRequest = CertificateRequest(10L, CertificateType.NDFL)
    }

    @Test
    fun receiveRequestTest() {

    }


    @Test
    fun processNextRequestTest() {
    }
}