package com.dubizzle.local.mapper

/**
The mapper is to converting data from domain layer format to presentation layer format
*/
interface Mapper<T, E> {

    fun from(e: E): T

    fun to(t: T): E

}