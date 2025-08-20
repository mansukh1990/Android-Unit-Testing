package com.example.androidunittesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import com.example.androidunittesting.NotesApp.MainNoteActivity
import org.junit.Rule
import org.junit.Test

class MainNoteActivityTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainNoteActivity>()

    @Test
    fun textSubmitButton_Expected_CorrectValue() {
        onView(withId(R.id.txt_title)).perform(typeText("Hello"))
        onView(withId(R.id.txt_dec))
            .perform(typeText("MansukhMakwana"), closeSoftKeyboard())

        onView(withId(R.id.btn_submit)).perform(click())

        onView(withId(R.id.txt_message))
            .check(matches(withText("Title - Hello | Desc - MansukhMakwana")))
    }
}