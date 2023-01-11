package com.example.partyplanner

import com.example.partyplanner.fireBaseServices.MailSender
import com.example.partyplanner.fireBaseServices.generateId
import org.junit.Test

import org.junit.Assert.*


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
    fun testGenerateId() {
        println(generateId())
    }


    @Test
    fun sendEmailTest() {
        MailSender.sendEmail("sig.goldbach@gmail.com", "MailFromApp", "Trying to send mail")


    }
}

