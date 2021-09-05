import io.mockk.mockk
import io.mockk.mockkConstructor
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import ru.sber.qa.Certificate
import ru.sber.qa.CertificateRequest
import ru.sber.qa.CertificateType
import kotlin.random.Random

internal class CertificateTest {
    private var certRequest = mockk<CertificateRequest>()
    private val processedBy = 10L
    private val byteArr : ByteArray = Random.nextBytes(100)
    private val certificate = Certificate(certRequest,processedBy, byteArr)


    @Test
    @DisplayName("Certificate Not Null")
    fun certificateNotNullTest() {
    assertNotNull(certificate)
    }

    @Test
    @DisplayName("Certificate request equals to Certificate request in Certificate ")
    fun getCertificateRequestTest(){
        assertEquals(certificate.certificateRequest, certRequest)
    }

    @Test
    @DisplayName("Processed data in certificate equals to certificate request")
    fun processedByCheckTest(){
        assertEquals(certificate.processedBy, processedBy)
    }

    @Test
    @DisplayName("ByteArr data in certificate equals to certificate request")
    fun byteArrCheckTest(){
        assertEquals(certificate.data, byteArr)
    }






}