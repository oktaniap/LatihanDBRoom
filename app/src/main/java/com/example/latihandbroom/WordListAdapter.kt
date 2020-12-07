package com.example.latihandbroom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    //convert file xml ke view object
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    //inisialisasi data
    private var words = emptyList<Word>()


    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }

    //membuat UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item,parent,false)
        return WordViewHolder(itemView)
    }

    //membuat UI sesuai dgn urutan data
    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = words[position]
        holder.wordItemView.text = current.word
    }

    //memasukkan data
    internal fun setWords(words: List<Word>){
        this.words = words
        notifyDataSetChanged()
    }

    //menghitung ukuran data
    override fun getItemCount() = words.size
}