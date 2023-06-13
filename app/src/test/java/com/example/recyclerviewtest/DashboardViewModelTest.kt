package com.example.recyclerviewtest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.recyclerviewtest.ui.dashboard.DashboardViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DashboardViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DashboardViewModel

    @Before
    fun setup() {
        viewModel = DashboardViewModel()
    }

    @Test
    fun testInitialTextValue() {
        val expectedText = "This is dashboard Fragment"
        val observedText = viewModel.text.value
        assert(observedText == expectedText)
    }
}