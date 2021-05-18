/*
 * Copyright 2017-2021 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

// This file was automatically generated from formats.md by Knit tool. Do not edit.
package example.exampleFormats06

import kotlinx.serialization.*
import kotlinx.serialization.protobuf.*

fun ByteArray.toAsciiHexString() = joinToString("") {
    if (it in 32..127) it.toInt().toChar().toString() else
        "{${it.toUByte().toString(16).padStart(2, '0').uppercase()}}"
}

@Serializable
class Data(
    @ProtoType(ProtoIntegerType.DEFAULT)
    val a: Int,
    @ProtoType(ProtoIntegerType.SIGNED)
    val b: Int,
    @ProtoType(ProtoIntegerType.FIXED)
    val c: Int
)

fun main() {
    val data = Data(1, -2, 3) 
    println(ProtoBuf.encodeToByteArray(data).toAsciiHexString())
}
