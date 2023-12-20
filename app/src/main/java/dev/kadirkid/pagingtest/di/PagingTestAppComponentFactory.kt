/**
 * Copyright (c) 2023 Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.kadirkid.pagingtest.di

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Build
import androidx.annotation.Keep
import androidx.annotation.RequiresApi
import androidx.core.app.AppComponentFactory
import javax.inject.Provider

@RequiresApi(Build.VERSION_CODES.P)
@Keep
class PagingTestAppComponentFactory : AppComponentFactory() {

    private inline fun <reified T> getInstance(
        cl: ClassLoader,
        className: String,
        providers: Map<Class<out T>, @JvmSuppressWildcards Provider<T>>,
    ): T? {
        val clazz = Class.forName(className, false, cl).asSubclass(T::class.java)
        val modelProvider = providers[clazz] ?: return null
        return modelProvider.get() as T
    }

    override fun instantiateActivityCompat(
        cl: ClassLoader,
        className: String,
        intent: Intent?,
    ): Activity {
        return getInstance(cl, className, applicationRef.applicationComponent.activityProviders)
            ?: super.instantiateActivityCompat(cl, className, intent)
    }

    override fun instantiateApplicationCompat(cl: ClassLoader, className: String): Application {
        val app = super.instantiateApplicationCompat(cl, className)
        applicationRef = (app as PagingTestApplication)
        return app
    }

    // AppComponentFactory can be created multiple times
    companion object {
        private lateinit var applicationRef: PagingTestApplication
    }
}
