package com.example.demoswiggy.quotesSection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.demoswiggy.databinding.ItemQuoteBinding
import com.example.demoswiggy.quotesSection.models.QuoteList
import com.example.demoswiggy.quotesSection.models.Result

import kotlin.Int

class QuotesAdapter(allQuotes: QuoteList) :
    RecyclerView.Adapter<QuotesAdapter.QuoteViewHolder>() {
    var quotes: QuoteList = allQuotes
    var quoteList: List<Result>

    init {        this.quoteList = allQuotes.results
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layoutBinding = ItemQuoteBinding.inflate(inflater,parent,false)
        return QuoteViewHolder(layoutBinding)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.dataBind(quoteList[holder.adapterPosition], holder.adapterPosition)
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }

    inner class QuoteViewHolder(private val layoutBinding: ItemQuoteBinding) : RecyclerView.ViewHolder(layoutBinding.root) {


        fun dataBind(quote: Result, index: Int) {
            layoutBinding.quote = quote
            layoutBinding.index = adapterPosition
        }
    }
}