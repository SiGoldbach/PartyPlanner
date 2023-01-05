package com.example.partyplanner

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.partyplanner.viewModel.ViewModelOnApp
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.math.abs

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.partyplanner", appContext.packageName)
    }

    /**
     * The purpose of this test is to create 5 events and then get them. from firebase,
     * will never work since the app needs to be started to work
     */


    /**
     * Testing time
     */
    @Test
    fun testingRandom() {
        val random = abs((0..99999999999).random())
        println(random)
    }
}