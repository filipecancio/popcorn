package dev.cancio.filmin.util

import com.google.gson.Gson
import java.io.Closeable
import java.lang.reflect.Type

object ResourceReader {

    fun readFromResources(fileName: String): String = this
        .javaClass.classLoader?.getResourceAsStream(fileName)
        ?.closing { source ->
            source.closing { buffer ->
                buffer
                    .reader()
                    .readText()
            }
        }.orEmpty()

    fun <K : Closeable, T> K.closing(action: (K) -> T): T = action(this)

    fun <T> readJsonMock(
        fileName: String,
        type: Type
    ): T = readFromResources(fileName).let { json ->
        Gson().fromJson(json, type)
    }
}