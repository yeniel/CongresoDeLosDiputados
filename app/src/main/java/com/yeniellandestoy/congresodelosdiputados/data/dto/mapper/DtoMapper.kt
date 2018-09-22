package com.yeniellandestoy.congresodelosdiputados.data.dto.mapper

import java.util.*

/**
 * Created by yeniel on 20/2/18.
 */
abstract class DtoMapper<Model, Dto> {

    abstract fun transform(entity: Dto?): Model?

    fun transform(collection: Collection<Dto>): List<Model> {
        val list = ArrayList<Model>()
        var model: Model?

        for (entity in collection) {
            model = transform(entity)

            if (model != null) {
                list.add(model)
            }
        }

        return list
    }
}