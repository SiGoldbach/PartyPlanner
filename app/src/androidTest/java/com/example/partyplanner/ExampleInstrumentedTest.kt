package com.example.partyplanner

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.partyplanner.viewModel.ViewModelOnApp

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

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
     * The purpose of this test is to create 5 events and then get them. from firebase
     */
    @Test
    fun viewModelTest() {
        var boolean = false
        val model = ViewModelOnApp()
        model.createEvent("e1", "e1", "e1")
        model.createEvent("e2", "e2", "e2")
        model.createEvent("e3", "e3", "e3")
        model.createEvent("e4", "e4", "e4")
        model.createEvent("e5", "e5", "e5")
        model.getAllEvents()


    }
}