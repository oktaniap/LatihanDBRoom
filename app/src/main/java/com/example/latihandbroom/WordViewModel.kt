package com.example.latihandbroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//sebagai pemegang data yg dapat diambil
class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository:WordRepository

    val allWords: LiveData<List<Word>>

    init {
        val wordsDao=WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository= WordRepository(wordsDao)
        allWords=repository.allWords
    }

    //untuk fungsi insert
    fun insert(word:Word)=viewModelScope.launch {
        repository.insert(word)
    }
    //untuk fungsi delete
    fun deleteAll() = viewModelScope.launch{
        repository.deleteAll()
    }

}