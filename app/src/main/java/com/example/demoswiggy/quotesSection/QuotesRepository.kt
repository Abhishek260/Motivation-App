package com.example.demoswiggy.quotesSection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demoswiggy.api.QuoteService
import com.example.demoswiggy.quotesSection.models.QuoteList

class QuotesRepository (private val quoteService: QuoteService) {

    private val quotesLiveData = MutableLiveData<QuoteList>()
    private val _isLoading = MutableLiveData<Boolean>()

    val quotes: LiveData<QuoteList>
        get() = quotesLiveData

    val isLoading: LiveData<Boolean>
        get() = _isLoading

    suspend fun getQuotes(page: Int){
        _isLoading.postValue(true)
        val result = quoteService.getQuotes(page)
        if (result?.body()!=null){
            quotesLiveData.postValue(result.body())
        }
        _isLoading.postValue(false)
    }
}