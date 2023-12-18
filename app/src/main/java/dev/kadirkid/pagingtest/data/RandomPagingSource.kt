/**
 * Copyright 2023 Abdulahi Osoble
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.kadirkid.pagingtest.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlin.random.Random

class RandomPagingSource: PagingSource<Int, String>() {
    override fun getRefreshKey(state: PagingState<Int, String>): Int? =
        state.anchorPosition?.let { state.closestPageToPosition(anchorPosition = it) }?.prevKey

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> = LoadResult.Page(
        data = generateSequence { Random.nextDouble().toString() }.take(params.loadSize).toList(),
        nextKey = Random.nextInt(),
        prevKey = params.key
    )
}

class RandomPagingSourceFactory {
    fun create(): RandomPagingSource = RandomPagingSource()
}
