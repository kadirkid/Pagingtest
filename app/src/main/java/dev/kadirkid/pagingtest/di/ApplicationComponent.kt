/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
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
