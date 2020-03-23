package com.codingwithmitch.espressouitestexamples.ui.main

import androidx.test.core.app.ActivityScenario
import com.codingwithmitch.espressouitestexamples.R

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest {
    @get: Rule
    val activityRule: ActivityScenarioRule<SecondaryActivity> =
        ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun testIsActivityInView() {
        onView(withId(R.id.secondary))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testIsTitleVisible() {
        onView(withId(R.id.activity_secondary_title))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testIsButtonVisible() {
        onView(withId(R.id.button_back))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testIsTitleTextCorrect() {
        onView(withId(R.id.activity_secondary_title))
            .check(matches(withText(R.string.text_secondaryactivity)))
    }

    @Test
    fun testIsButtonTextCorrect() {
        onView(withId(R.id.button_back))
            .check(matches(withText(R.string.text_back)))
    }

    @Test
    fun testNavMainActivityUsingButton() {
        onView(withId(R.id.button_back))
            .perform(click())

        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testNavMainActivityUsingBack() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button_next_activity))
            .perform(click())

        pressBack()
        onView(withId(R.id.main))
            .check(matches(isDisplayed()))
    }
}