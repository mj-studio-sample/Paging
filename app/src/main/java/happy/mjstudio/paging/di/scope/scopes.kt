package happy.mjstudio.paging.di.scope

import javax.inject.Scope

/**
 * Created by mj on 24, November, 2019
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope