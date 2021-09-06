import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.sber.qa.Certificate
import ru.sber.qa.CertificateRequest
import ru.sber.qa.CertificateType
import ru.sber.qa.Scanner
import kotlin.random.Random
import kotlin.test.assertNotNull

internal class CertificateRequestTest {
    private val certificateType = mockk<CertificateType>()
    private val employeNum = 10L
    private val hrEmployeeNum = 2L
    private val byteArr = byteArrayOf(1,2,3,4,5)
    private val certificateReq = CertificateRequest(employeNum, certificateType)

    @Test
    fun employeNumTest(){
        assertEquals(certificateReq.employeeNumber, employeNum)
    }

    @Test
    fun certificateTypeTest(){
        assertEquals(certificateReq.certificateType, certificateType)
    }

    @Test
    @DisplayName("Certificate request fun process test")
    fun certificateRequestProcessTest(){

        assertNotNull(certificateReq.process(2L))

        mockkObject(Random)
        every { Random.nextLong(5000L, 15000L) } returns 5001L
        every { Random.nextBytes(100) } returns byteArr
        val certificate = certificateReq.process(2L)
        assertEquals(certificate.data, byteArr)
        assertEquals(certificate.processedBy, hrEmployeeNum)
        assertEquals(certificate.certificateRequest, certificateReq)
    }

}