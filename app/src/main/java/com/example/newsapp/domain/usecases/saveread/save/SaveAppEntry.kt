package com.example.newsapp.domain.usecases.saveread.save

import com.example.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}