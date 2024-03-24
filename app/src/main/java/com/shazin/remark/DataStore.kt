package com.shazin.remark

import com.google.gson.Gson


data class Note(
    val uuid: String,
    val body: String,
    val createdAt: Long,
    val updatedAt: Long,
)
fun serializeNoteFile(note: Note){
    val gson = Gson()
    return gson.
}