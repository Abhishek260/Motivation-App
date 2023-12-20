package com.example.demoswiggy.quotesSection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoswiggy.R
import com.example.demoswiggy.api.QuoteService
import com.example.demoswiggy.api.RetrofitHelper

import com.example.demoswiggy.databinding.ActivityQuotesBinding
import com.example.demoswiggy.quotesSection.models.QuoteList
import com.example.demoswiggy.quotesSection.viewModels.MainViewModel
import com.example.demoswiggy.quotesSection.viewModels.MainViewModelFactory


class QuotesActivity : AppCompatActivity() {
    private lateinit var activityBinding: ActivityQuotesBinding
    private val TAG = "QuotesActivity"
    private lateinit var mainViewModel: MainViewModel
    private lateinit var allQuotes: QuoteList
    private var quoteAdapter: QuotesAdapter? = null
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_quotes)
        activityBinding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuotesRepository(quoteService)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        setObservers()
    }
    private fun setObservers(){
        mainViewModel.quotes.observe(this){ quotes ->
            allQuotes = quotes
            setupRecyclerView()
            Log.d(TAG, "setObservers: ")
        }
        mainViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                showProgressBar()
            } else {
                hideProgressBar()
            }
        }
    }
    private fun showProgressBar() {
        activityBinding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        activityBinding.progressBar.visibility = View.GONE
    }


    private fun setupRecyclerView() {
        if(quoteAdapter == null) {
            layoutManager = LinearLayoutManager(this)
            activityBinding.rvDemo.layoutManager = layoutManager
            quoteAdapter = QuotesAdapter(allQuotes)
        }
        activityBinding.rvDemo.adapter = quoteAdapter

    }

}