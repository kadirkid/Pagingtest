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
package dev.kadirkid.pagingtest.di

import android.app.Activity
import android.app.Application
import androidx.fragment.app.FragmentFactory
import com.kadirkid.rickandmortydi.AppScope
import com.kadirkid.rickandmortydi.SingleIn
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Provider
import javax.inject.Singleton

@MergeComponent(scope = AppScope::class)
@SingleIn(AppScope::class)
@Singleton
interface ApplicationComponent {

    val activityProviders: Map<Class<out Activity>, @JvmSuppressWildcards Provider<Activity>>

    fun inject(application: PagingTestApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}
