/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.data

import androidx.paging.PagingSource
import androidx.paging.testing.asSnapshot
import dev.kadirkid.pagingtest.character.data.CharacterPagingSource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import kotlin.RuntimeException
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class MainViewModelTest {
//    private val source: CharacterPagingSource = spyk()
//    private val sourceFactory: RandomPagingSourceFactory = mockk {
//        every { create() } returns source
//    }
//
//    private val viewModel = MainViewModel(sourceFactory)
//
//    @Test
//    fun successfulWithSingleLoadIfNoNextKey() {
//        runTest {
//            coEvery { source.load(any()) } returns PagingSource.LoadResult.Page(
//                data = listOf("Kazuma"),
//                prevKey = null,
//                nextKey = null
//            )
//
//            val result = viewModel.uiState.asSnapshot()
//
//            assertEquals(listOf("Kazuma"), result)
//        }
//    }
//
//    @Test
//    fun successfulWithMultipleLoadsIfDataIsInsufficient() {
//        runTest {
//            coEvery { source.load(any()) } returns PagingSource.LoadResult.Page(
//                data = listOf("Kazuma", "Hiruma", "Kazuma"),
//                prevKey = null,
//                nextKey = 2
//            ) andThen PagingSource.LoadResult.Page(
//                data = listOf("Kazuma", "Hiruma", "Kazuma", "Hiruma"),
//                prevKey = 2,
//                nextKey = 3
//            ) andThen PagingSource.LoadResult.Page(
//                data = listOf("Kazuma", "Hiruma"),
//                prevKey = 3,
//                nextKey = 4
//            ) andThen PagingSource.LoadResult.Page(
//                data = listOf("Kazuma"),
//                prevKey = 4,
//                nextKey = 5
//            ) andThen PagingSource.LoadResult.Page(
//                data = listOf("Kazuma"),
//                prevKey = 5,
//                nextKey = 6
//            ) andThen PagingSource.LoadResult.Page(
//                data = listOf("Kazuma"),
//                prevKey = 6,
//                nextKey = 7
//            ) andThen PagingSource.LoadResult.Page(
//                data = listOf("Kazuma"),
//                prevKey = 7,
//                nextKey = 8
//            )
//
//            val result = viewModel.uiState.asSnapshot()
//            val expected = listOf(
//                "Kazuma",
//                "Hiruma",
//                "Kazuma",
//                "Kazuma",
//                "Hiruma",
//                "Kazuma",
//                "Hiruma",
//                "Kazuma",
//                "Hiruma",
//                "Kazuma",
//                "Kazuma",
//                "Kazuma"
//            )
//            assertEquals(expected, result)
//
//            coVerify(exactly = 6) { source.load(any()) }
//        }
//    }
//
//    @Test
//    fun successfulWithMultipleLoadsUntilNextKeyIsNull() {
//        runTest {
//            coEvery { source.load(any()) } returns PagingSource.LoadResult.Page(
//                data = listOf("Kazuma", "Hiruma", "Kazuma"),
//                prevKey = null,
//                nextKey = 2
//            ) andThen PagingSource.LoadResult.Page(
//                data = listOf("Kazuma", "Hiruma", "Kazuma", "Hiruma"),
//                prevKey = 2,
//                nextKey = 3
//            ) andThen PagingSource.LoadResult.Page(
//                data = listOf("Kazuma", "Hiruma"),
//                prevKey = 3,
//                nextKey = null
//            ) andThen PagingSource.LoadResult.Page(
//                data = listOf("NOTCALLED"),
//                prevKey = 4,
//                nextKey = 5
//            )
//
//            val result = viewModel.uiState.asSnapshot()
//            val expected = listOf(
//                "Kazuma",
//                "Hiruma",
//                "Kazuma",
//                "Kazuma",
//                "Hiruma",
//                "Kazuma",
//                "Hiruma",
//                "Kazuma",
//                "Hiruma"
//            )
//            assertEquals(expected, result)
//
//            coVerify(exactly = 3) { source.load(any()) }
//        }
//    }
//
//    @Test
//    fun failure() {
//        runTest {
//            coEvery { source.load(any()) } returns PagingSource.LoadResult.Error(RuntimeException("Tough luck"))
//            try {
//                viewModel.uiState.asSnapshot()
//                fail("Should fail with RuntimeException")
//            } catch (e: RuntimeException) {
//                assertEquals("Tough luck", e.message)
//            }
//        }
//    }
}
