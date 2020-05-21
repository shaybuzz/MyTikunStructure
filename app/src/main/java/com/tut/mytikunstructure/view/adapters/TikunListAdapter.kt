package com.tut.mytikunstructure.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tut.mytikunstructure.databinding.ItemHeaderPasokLayoutBinding
import com.tut.mytikunstructure.databinding.ItemSentenceLayoutBinding
import com.tut.mytikunstructure.model.TikunItem
import kotlinx.android.synthetic.main.item_header_pasok_layout.view.*
import kotlinx.android.synthetic.main.item_sentence_layout.view.*

enum class TikunItemType {
    HEADER,
    SENTENCE
}

class TikunListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<TikunItem> = mutableListOf()

    fun update(items: List<TikunItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    class HeaderViewHolder(itemView: ItemHeaderPasokLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        fun bind(tikunItem: TikunItem) {
            itemView.pasokText.text = tikunItem.text
        }
    }

    class SentenceViewHolder(itemView: ItemSentenceLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        fun bind(tikunItem: TikunItem) {
            itemView.sentenceText.text = tikunItem.text
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items.get(position).type.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TikunItemType.HEADER.ordinal -> {
                val binding = ItemHeaderPasokLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                HeaderViewHolder(binding)
            }
            TikunItemType.SENTENCE.ordinal -> {
                val binding = ItemSentenceLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                SentenceViewHolder(binding)
            }
            else -> {
                throw IllegalArgumentException("Type not supported")
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TikunItemType.SENTENCE.ordinal -> {
                (holder as SentenceViewHolder).bind(items.get(position))
            }
            TikunItemType.HEADER.ordinal -> {
                (holder as HeaderViewHolder).bind(items.get(position))
            }
        }
    }


}