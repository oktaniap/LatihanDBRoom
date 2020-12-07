package com.example.latihandbroom

import androidx.lifecycle.LiveData

//sebagai repository
class WordRepository(private val wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()
    suspend fun insert(word: Word){
        wordDao.insert(word)
    }

    suspend fun deleteAll(){
        wordDao.deleteAll()
    }
}