package com.example.demoswiggy.quotesSection.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demoswiggy.quotesSection.QuotesRepository

class MainViewModelFactory (private val repository: QuotesRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository)as T
    }
}