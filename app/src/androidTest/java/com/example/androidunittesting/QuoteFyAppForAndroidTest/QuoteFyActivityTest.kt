package com.example.androidunittesting.QuoteFyAppForAndroidTest

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import com.example.androidunittesting.R
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test

class QuoteFyActivityTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<QuoteFyActivity>()

    @Test
    fun testNextButton_Expected_CorrectQuote() {

        onView(withId(R.id.btn_next)).perform(click())
        onView(withId(R.id.btn_next)).perform(click())
        onView(withId(R.id.btn_next)).perform(click())
        onView(withId(R.id.quoteText)).check(matches(withText("Difficulties increase the nearer we get to the goal.")))
    }

    @Test
    fun shareButton_Expected_Intent_Chooser() {
        Intents.init()

        val expected = allOf(hasAction(Intent.ACTION_SEND))
        onView(withId(R.id.floatingActionButton)).perform(click())
        intended(expected)
        Intents.release()
    }

}