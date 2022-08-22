package com.dubizzle.androidtask

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.dubizzle.androidtask.ui.DetailActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class DetailActivityTest {

    @get:Rule()
    val rule = ActivityTestRule(DetailActivity::class.java)

    @Test
    fun test_right_uid_displayed() {
        onView(withId(R.id.uid))
            .check(matches(withText(getResourceString(R.string.uid))))
    }

    @Test
    fun test_correct_CreatedAt_displayed() {
        onView(withId(R.id.create_at))
            .check(matches(withText(getResourceString(R.string.create_at))))
    }
    @Test
    fun test_correct_Price_displayed() {
        onView(withId(R.id.price))
            .check(matches(withText(getResourceString(R.string.price))))
    }

    private fun getResourceString(id: Int): String {
        val targetContext: Context = ApplicationProvider.getApplicationContext()
        return targetContext.resources.getString(id)
    }
}
