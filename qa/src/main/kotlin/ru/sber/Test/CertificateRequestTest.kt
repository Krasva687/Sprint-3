import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.sber.qa.CertificateRequest
import ru.sber.qa.CertificateType
import kotlin.test.assertNotNull

internal class CertificateRequestTest {


    @Test
    @DisplayName("Certificate request fun process test")
    fun certificateRequestProcess(){
        assertNotNull(CertificateRequest(1L, CertificateType.NDFL).process(2L))
    }
}