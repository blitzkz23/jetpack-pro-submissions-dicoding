package com.app.myviewmodel

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.rules.ExpectedException

class MainViewModelTest {
	private lateinit var mainViewModel: MainViewModel

	@Before
	fun init() {
		mainViewModel = MainViewModel()
	}

	@get:Rule
	var thrown = ExpectedException.none()

	// Test that expect float inputs
	@Test
	@Throws(NumberFormatException::class)
	fun calculate() {
		val width = "1"
		val length = "2"
		val height = "8.9"
		thrown.expect(NumberFormatException::class.java)
		thrown.expectMessage("For input string: \"8.9\"")
		mainViewModel.calculate(width, length, height)
		assertEquals(6, mainViewModel.result)
	}

	// Test input char
	@Test
	@Throws(java.lang.NumberFormatException::class)
	fun characterInputCalculateTest() {
		val width = "1"
		val length = "A"
		val height = "3"
		thrown.expect(java.lang.NumberFormatException::class.java)
		thrown.expectMessage("For input string: \"A\"")
		mainViewModel.calculate(width, length, height)
	}

	@Test
	@Throws(java.lang.NumberFormatException::class)
	fun emptyInputCalculateTest() {
		val width = "1"
		val length = "2"
		val height = ""
		thrown.expect(java.lang.NumberFormatException::class.java)
		thrown.expectMessage("For input string: \"\"")
		mainViewModel.calculate(width, length, height)
	}
}