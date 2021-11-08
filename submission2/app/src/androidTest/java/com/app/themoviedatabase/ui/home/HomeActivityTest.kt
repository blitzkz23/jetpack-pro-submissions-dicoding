package com.app.themoviedatabase.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.app.themoviedatabase.R
import com.app.themoviedatabase.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
	private val dummyMovie = DataDummy.generateDummyMovies()
	private val dummyShow = DataDummy.generateDummyTvShows()

	@get:Rule
	var activityRule = ActivityScenarioRule(HomeActivity::class.java)

	@Test
	fun loadMovies() {
		onView(withId(R.id.rv_movie))
			.check(ViewAssertions.matches(isDisplayed()))
		onView(withId(R.id.rv_movie))
			.perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
	}

	@Test
	fun loadDetailMovie() {
		onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
			ViewActions.click()
		))
		onView(withId(R.id.tv_detail_title)).check(ViewAssertions.matches(isDisplayed()))
		onView(withId(R.id.tv_detail_title)).check(ViewAssertions.matches(withText(dummyMovie[0].title)))
		onView(withId(R.id.tv_detail_date)).check(ViewAssertions.matches(isDisplayed()))
		onView(withId(R.id.tv_detail_date)).check(ViewAssertions.matches(withText(dummyMovie[0].releaseDate)))
	}

	@Test
	fun loadTvShows() {
		onView(withText("TV Show")).perform(ViewActions.click())
		onView(withId(R.id.rv_tv_show)).check(ViewAssertions.matches(isDisplayed()))
		onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShow.size))
	}

	@Test
	fun loadDetailTvShows() {
		onView(withText("TV Show")).perform(ViewActions.click())
		onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
			ViewActions.click()
		))
		onView(withId(R.id.tv_detail_title)).check(ViewAssertions.matches(isDisplayed()))
		onView(withId(R.id.tv_detail_title)).check(ViewAssertions.matches(withText(dummyShow[0].title)))
		onView(withId(R.id.tv_detail_date)).check(ViewAssertions.matches(isDisplayed()))
		onView(withId(R.id.tv_detail_date)).check(ViewAssertions.matches(withText(dummyShow[0].releaseDate)))
	}
}