package com.yeniellandestoy.congresodelosdiputados.data.dto.mapper

import com.yeniellandestoy.congresodelosdiputados.data.dto.VotacionDto
import com.yeniellandestoy.congresodelosdiputados.domain.model.Votacion
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by yeniel on 13/2/18.
 */
@Singleton
class VotacionDtoMapper @Inject constructor() : DtoMapper<Votacion, VotacionDto>() {

    override fun transform(entity: VotacionDto?): Votacion? {
        var votacion: Votacion? = null

        if (entity != null) {
            votacion = Votacion(legislatura = entity.legislatura.toInt(),
                    sesion = entity.sesion.toInt(),
                    numeroVotacion = entity.numeroVotacion.toInt())
        }

        return votacion
    }

}