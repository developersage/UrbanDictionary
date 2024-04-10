package com.sangdo.network.module

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UrbanDictionaryURL

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthHeader

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HeaderInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RapidOkHttpClient

