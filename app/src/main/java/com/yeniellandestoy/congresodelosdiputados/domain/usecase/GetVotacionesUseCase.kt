package com.yeniellandestoy.congresodelosdiputados.domain.usecase

import com.yeniellandestoy.congresodelosdiputados.domain.executor.PostExecutionThread
import com.yeniellandestoy.congresodelosdiputados.domain.executor.ThreadExecutor
import com.yeniellandestoy.congresodelosdiputados.domain.model.Votacion
import com.yeniellandestoy.congresodelosdiputados.domain.repository.VotacionRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by yeniel on 3/3/18.
 */
class GetVotacionesUseCase @Inject constructor(threadExecutor: ThreadExecutor,
                                               postExecutionThread: PostExecutionThread,
                                               private val votacionRepository: VotacionRepository) : UseCase<List<Votacion>, GetVotacionesUseCase.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): Observable<List<Votacion>> {
        return this.votacionRepository.getAll()
    }

    class Params private constructor() {

    }
}