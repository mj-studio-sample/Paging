package happy.mjstudio.paging.domain.usecase

/**
 * Created by mj on 25, November, 2019
 */
interface CoroutineUseCase <T, in Param> {
    suspend fun execute(param : Param) : T
}