package happy.mjstudio.paging.domain.usecase

/**
 * Created by mj on 25, November, 2019
 */
interface UseCase <T, in Param> {
    fun execute(param : Param) : T
}