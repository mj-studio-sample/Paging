package happy.mjstudio.paging.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import happy.mjstudio.paging.di.scope.ApplicationScope
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

/**
 * Created by mj on 25, November, 2019
 */
@Module
class NetworkModule {
    @Provides
    @ApplicationScope
    fun provideRetrofit(client : OkHttpClient,gson : Gson) : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideGson() : Gson {
        return GsonBuilder()
            .create()
    }

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(@Named("LoggingInterceptor") loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .callTimeout(3000L,TimeUnit.MILLISECONDS)
            .build()
    }

    @Provides
    @Named("LoggingInterceptor")
    @ApplicationScope
    fun provideLoggerInterceptor() : Interceptor {
        return HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    }


}