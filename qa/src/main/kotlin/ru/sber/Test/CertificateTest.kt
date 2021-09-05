import io.mockk.mockk
import io.mockk.mockkConstructor
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import ru.sber.qa.Certificate
import ru.sber.qa.CertificateRequest
import ru.sber.qa.CertificateType

internal class CertificateTest {
    private var certRequest = mockk<CertificateRequest>()
    private val processedBy = 10L
    private val byteArr : ByteArray = byteArrayOf(1,2,3,4,5)
    private val certificate = Certificate(certRequest,processedBy, byteArr)


    @Test
    @DisplayName("Certificate Not Null")
    fun certificateNotNull() {
    assertNotNull(certificate)
    }

    @Test
    @DisplayName("Certificate request equals to Certificate request in Certificate ")
    fun getCertificateRequest(){
        assertEquals(certificate.certificateRequest, certRequest)
    }

    @Test
    @DisplayName("Processed data in certificate equals to certificate request")
    fun processedByCheck(){
        assertEquals(certificate.processedBy, processedBy)
    }

    @Test
    @DisplayName("ByteArr data in certificate equals to certificate request")
    fun byteArrCheck(){
        assertEquals(certificate.data, byteArr)
    }






}