package com.app.myidlingresource

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import com.app.EspressoIdlingResource
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MainActivityTest {
	private lateinit var instrumentalContext: Context

	@Before
	fun setUp() {
		instrumentalContext = InstrumentationRegistry.getInstrumentation().targetContext

		ActivityScenario.launch(MainActivity::class.java)
		IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
	}

	@Test
	fun checkText() {
		onView(withId(R.id.text_view)).check(matches(withText(instrumentalContext.getString(R.string.prepare))))
		onView(withText(instrumentalContext.getString(R.string.start))).perform(click())

		onView(withId(R.id.text_view)).check(matches(withText(instrumentalContext.getString(R.string.delay2))))
	}

	@After
	fun tearDown() {
		IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
	}
}