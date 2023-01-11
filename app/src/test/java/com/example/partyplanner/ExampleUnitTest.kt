package com.example.partyplanner

import com.example.partyplanner.fireBaseServices.MailSender
import org.junit.Test

import org.junit.Assert.*
import java.util.Properties
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }



        @Test
        fun sendEmailTest() {
            val credentials = EmailCredentials("partyplannerdk@gmail.com", "isznshvcwlewebov")
            val mailConfig = MailConfig("smtp.gmail.com", 587, true, true)
            val mailProperties = MailProperties()

            val props = mailProperties.getProperties(mailConfig)

            Assertions.assertDoesNotThrow {
                MailSender.sendEmail(credentials, props, "recipient@example.com", "Test Subject", "Test Body")

        }
    }

}

