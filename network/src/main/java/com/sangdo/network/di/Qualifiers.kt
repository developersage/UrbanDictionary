package com.sangdo.network.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RapidAPIBaseURL

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UrbanDictionaryHOST

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UrbanDictionaryKEY

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthHeader

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HeaderInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RapidOkHttpClient

