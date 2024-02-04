package com.example.newsapp.domain.usecases.saveread.read

import com.example.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    operator fun invoke():Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}