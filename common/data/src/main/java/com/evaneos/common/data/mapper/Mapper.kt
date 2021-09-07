package com.evaneos.common.data.mapper

interface Mapper<A, B> {
    operator fun invoke(obj: A): B
}
