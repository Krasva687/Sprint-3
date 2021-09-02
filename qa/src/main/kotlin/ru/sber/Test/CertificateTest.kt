import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.sber.qa.Certificate
import ru.sber.qa.CertificateRequest
import ru.sber.qa.CertificateType

internal class CertificateTest {

    @Test
    fun createClass() {
    assertNotNull(Certificate(CertificateRequest(10L,CertificateType.NDFL), 20L, byteArrayOf(1,2,3,4)))
    }
}