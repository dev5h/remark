package com.shazin.remark

import android.content.Context
import com.google.gson.Gson
import java.io.File


data class Note(
    val uuid: String,
    val body: String,
    val createdAt: Long,
    val updatedAt: Long,
)
fun serializeNoteFile(note: Note): String{
    val gson = Gson()
    return gson.toJson(note)
}

class DataStore(
    val context: Context
){
    private fun saveLocal(uuid: String, json: String){
        val path = context.dataDir.path.plus("${uuid}.db")
        File(path).writeText(json)
    }
    fun saveNote(note: Note){
        saveLocal(note.uuid, serializeNoteFile(note))
    }
}