import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.sber.qa.CertificateType

internal class CertificateTypeTest {

    @Test
    @DisplayName("Certificate type class test")
    fun checkTypesTest(){
        assertNotNull(CertificateType.NDFL)
        assertNotNull(CertificateType.LABOUR_BOOK)
        assertEquals(CertificateType.values().size, 2)
    }
}