package com.example.newsapp.domain.usecases.saveread

import com.example.newsapp.domain.usecases.saveread.read.ReadAppEntry
import com.example.newsapp.domain.usecases.saveread.save.SaveAppEntry

data class AppEntryUseCases(
    val readAppEntry: ReadAppEntry,
    val saveAppEntry: SaveAppEntry
)
