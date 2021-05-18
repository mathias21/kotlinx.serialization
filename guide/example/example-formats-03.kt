/*
 * Copyright 2017-2021 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

// This file was automatically generated from formats.md by Knit tool. Do not edit.
package example.exampleFormats03

import kotlinx.serialization.*
import kotlinx.serialization.cbor.*

fun ByteArray.toAsciiHexString() = joinToString("") {
    if (it in 32..127) it.toInt().toChar().toString() else
        "{${it.toUByte().toString(16).padStart(2, '0').uppercase()}}"
}

@Serializable
data class Data(
    @ByteString
    val type2: ByteArray, // CBOR Major type 2
    val type4: ByteArray  // CBOR Major type 4
)        

fun main() {
    val data = Data(byteArrayOf(1, 2, 3, 4), byteArrayOf(5, 6, 7, 8)) 
    val bytes = Cbor.encodeToByteArray(data)   
    println(bytes.toAsciiHexString())
    val obj = Cbor.decodeFromByteArray<Data>(bytes)
    println(obj)
}
