import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkClass
import io.mockk.mockkConstructor
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import ru.sber.qa.*
import java.time.Clock
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*
import kotlin.test.assertFailsWith

internal class HrDepartmentTest {
    private var certificateRequest = mockk<CertificateRequest>()
    private var clockFormat = ZoneOffset.UTC
    private var certificate = mockk<Certificate>()
    private var hrEmployeeNum = 10L
    @Test
    fun weekDayExceptionTest(){
        HrDepartment.clock = Clock.fixed(Instant.parse("2021-09-05T15:30:00Z"), clockFormat)
        assertThrows(WeekendDayException::class.java, {HrDepartment.receiveRequest(certificateRequest)})
        HrDepartment.clock = Clock.fixed(Instant.parse("2021-09-04T15:30:00Z"), clockFormat)
        assertThrows(WeekendDayException::class.java, {HrDepartment.receiveRequest(certificateRequest)})
    }

    @Test
    fun notAllowRequestExceptionTest(){
        //Check LABOUR_BOOK exception for Monday
        HrDepartment.clock = Clock.fixed(Instant.parse("2021-08-30T15:30:00Z"), clockFormat)
        every { certificateRequest.certificateType } returns CertificateType.LABOUR_BOOK
        assertThrows(NotAllowReceiveRequestException::class.java, {HrDepartment.receiveRequest(certificateRequest)})

        //Check LABOUR_BOOK exception for Wednesday
        HrDepartment.clock = Clock.fixed(Instant.parse("2021-09-01T15:30:00Z"), clockFormat)
        every { certificateRequest.certificateType } returns CertificateType.LABOUR_BOOK
        assertThrows(NotAllowReceiveRequestException::class.java, {HrDepartment.receiveRequest(certificateRequest)})

        //Check LABOUR_BOOK exception for Friday
        HrDepartment.clock = Clock.fixed(Instant.parse("2021-09-03T15:30:00Z"), clockFormat)
        every { certificateRequest.certificateType } returns CertificateType.LABOUR_BOOK
        assertThrows(NotAllowReceiveRequestException::class.java, {HrDepartment.receiveRequest(certificateRequest)})

        //Check NDFL exception for Tuesday
        HrDepartment.clock = Clock.fixed(Instant.parse("2021-08-31T15:30:00Z"), clockFormat)
        every { certificateRequest.certificateType } returns CertificateType.NDFL
        assertThrows(NotAllowReceiveRequestException::class.java, {HrDepartment.receiveRequest(certificateRequest)})

        //Check NDFL exception for Thursday
        HrDepartment.clock = Clock.fixed(Instant.parse("2021-09-02T15:30:00Z"), clockFormat)
        every { certificateRequest.certificateType } returns CertificateType.NDFL
        assertThrows(NotAllowReceiveRequestException::class.java, {HrDepartment.receiveRequest(certificateRequest)})

    }

    @Test
    fun receiveRequestTest() {
        HrDepartment.clock = Clock.fixed(Instant.parse("2021-09-02T15:30:00Z"), clockFormat)
        every { certificateRequest.certificateType } returns CertificateType.LABOUR_BOOK
        assertDoesNotThrow {HrDepartment.receiveRequest(certificateRequest)}
    }


    @Test
    fun processNextRequestTest() {
        HrDepartment.clock = Clock.fixed(Instant.parse("2021-09-02T15:30:00Z"), clockFormat)
        every { certificateRequest.process(hrEmployeeNum) } returns certificate
        every {certificateRequest.certificateType} returns CertificateType.LABOUR_BOOK

        HrDepartment.receiveRequest(certificateRequest)
        assertDoesNotThrow { HrDepartment.processNextRequest(hrEmployeeNum) }
    }
}