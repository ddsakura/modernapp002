package com.example.recyclerviewtest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.example.recyclerviewtest.models.Item
import com.example.recyclerviewtest.models.Owner
import com.example.recyclerviewtest.ui.detail.DetailViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DetailViewModel

    @Before
    fun setup() {
        val savedStateHandle = SavedStateHandle().apply {
            // create a sample Item object to pass to the DetailViewModel
            val sampleItem = Item(
                id = 1,
                name = "Test Item",
                fullName = "Sample Item Repository",
                owner = Owner(
                    login = "john_doe",
                    id = 123,
                    avatarUrl = "https://example.com/avatar.png"
                ),
                private = false,
                htmlUrl = "https://github.com/sampleitem",
                description = "This is a sample item repository"
            )

            set("param", sampleItem)
        }
        viewModel = DetailViewModel(savedStateHandle)
    }

    @Test
    fun testGitItemValue() {
        val observedItem = viewModel.gitItem.value
        assert(observedItem != null)
        assert(observedItem?.name == "Test Item")
    }
}
