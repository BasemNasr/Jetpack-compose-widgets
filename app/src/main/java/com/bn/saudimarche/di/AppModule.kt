package com.bn.saudimarche.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().create()
    }

    /* @Provides
     @Singleton
     fun provideRetrofitClient(@ApplicationContext context: Context): ServiceApi {
         val loggingInterceptor = HttpLoggingInterceptor()
         loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

         val okHttpClient = OkHttpClient.Builder()
             .addInterceptor(loggingInterceptor)
             .readTimeout(60, TimeUnit.SECONDS)
             .connectTimeout(60, TimeUnit.SECONDS)
             .writeTimeout(60, TimeUnit.SECONDS)
             .addInterceptor { chain ->
                 val newRequest = chain.request().newBuilder()
                     .addHeader("Accept", "application/json")
                     .addHeader("Content-Type", "application/json")
                     .build()
                 val c = chain.proceed(newRequest)
                 c
             }
             .build()
         val baseUrl = Urls.ENDPOINT
         return Retrofit.Builder()
             .client(okHttpClient)
             .baseUrl(baseUrl)
             .addCallAdapterFactory(NetworkResponseAdapterFactory())
             .addConverterFactory(GsonConverterFactory.create())
             .build().create(ServiceApi::class.java)
     }*/
}