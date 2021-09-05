import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.sber.qa.CertificateRequest
import ru.sber.qa.CertificateType
import kotlin.test.assertNotNull

internal class CertificateRequestTest {
    private val certificateType = mockk<CertificateType>()
    private val employeNum = 10L
    private val certificateReq = CertificateRequest(employeNum, certificateType)

    @Test
    @DisplayName("Certificate request fun process test")
    fun certificateRequestProcessTest(){
        assertNotNull(certificateReq.process(2L))
    }

    @Test
    fun employeNumTest(){
        assertEquals(certificateReq.employeeNumber, employeNum)
    }

    @Test
    fun certificateTypeTest(){
        assertEquals(certificateReq.certificateType, certificateType)
    }

}