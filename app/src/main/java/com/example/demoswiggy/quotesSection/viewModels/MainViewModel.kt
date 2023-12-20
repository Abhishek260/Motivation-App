package com.example.demoswiggy.quotesSection.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoswiggy.quotesSection.QuotesRepository
import com.example.demoswiggy.quotesSection.models.QuoteList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (private val repository: QuotesRepository): ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }
    val quotes: LiveData<QuoteList>
        get() = repository.quotes
    val isLoading: LiveData<Boolean>
        get() = repository.isLoading
}