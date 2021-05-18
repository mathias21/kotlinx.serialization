/*
 * Copyright 2017-2021 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

// This file was automatically generated from formats.md by Knit tool. Do not edit.
package example.exampleFormats01

import kotlinx.serialization.*
import kotlinx.serialization.cbor.*

fun ByteArray.toAsciiHexString() = joinToString("") {
    if (it in 32..127) it.toInt().toChar().toString() else
        "{${it.toUByte().toString(16).padStart(2, '0').uppercase()}}"
}

@Serializable
data class Project(val name: String, val language: String)

fun main() {
    val data = Project("kotlinx.serialization", "Kotlin") 
    val bytes = Cbor.encodeToByteArray(data)   
    println(bytes.toAsciiHexString())
    val obj = Cbor.decodeFromByteArray<Project>(bytes)
    println(obj)
}
