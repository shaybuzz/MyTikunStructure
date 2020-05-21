package com.tut.mytikunstructure.view.automatic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tut.mytikunstructure.R
import com.tut.mytikunstructure.databinding.DecoratedTextFragmentBinding
import com.tut.mytikunstructure.databinding.ListTextFragmentBinding
import com.tut.mytikunstructure.model.TikunHeaderImpl
import com.tut.mytikunstructure.model.TikunItem
import com.tut.mytikunstructure.model.TikunSentenceImpl
import com.tut.mytikunstructure.view.adapters.TikunListAdapter

class TextListFragment:Fragment() {

    lateinit var binding: ListTextFragmentBinding
    val adapter:TikunListAdapter = TikunListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListTextFragmentBinding.inflate(layoutInflater, container, false)

        binding.tikunList.layoutManager = LinearLayoutManager(requireContext())
        binding.tikunList.setHasFixedSize(true)
        binding.tikunList.adapter = adapter


        adapter.update(generateItems())


        return binding.root
    }

    fun generateItems():List<TikunItem>{
        val list = mutableListOf<TikunItem>()
        list.add(TikunHeaderImpl("פסוק א ----"))
        list.add(TikunSentenceImpl("ברוך אתה אדוני"))
        list.add(TikunSentenceImpl("אשר עשני"))
        list.add(TikunSentenceImpl("בחסדיו"))
        list.add(TikunSentenceImpl("ובמו ידיו"))
        list.add(TikunHeaderImpl("פסוק ב ----"))
        list.add(TikunSentenceImpl("אין משיחין"))
        list.add(TikunSentenceImpl("בשעת הסעודהי"))
        list.add(TikunSentenceImpl("וגם חשוב לפני"))
        list.add(TikunSentenceImpl("לטל ידיים"))
        list.add(TikunHeaderImpl("פסוק ג ----"))
        list.add(TikunSentenceImpl("הבא"))
        list.add(TikunSentenceImpl("נגילהי"))
        list.add(TikunSentenceImpl("הבא"))
        list.add(TikunSentenceImpl("נרננהו"))
        list.add(TikunSentenceImpl("הבא"))
        list.add(TikunSentenceImpl("נרננהו"))
        list.add(TikunSentenceImpl("הבא הבא"))
        list.add(TikunSentenceImpl("נרננהו"))
        list.add(TikunSentenceImpl("ונשמחה"))
        list.add(TikunHeaderImpl("פסוק ד ----"))
        list.add(TikunSentenceImpl("אין אלחק"))
        list.add(TikunSentenceImpl("בשעת בליק"))
        list.add(TikunSentenceImpl("וגם בום לפני"))
        list.add(TikunSentenceImpl("וגם בום טודו"))
        list.add(TikunSentenceImpl("טודו בום לפני"))
        list.add(TikunSentenceImpl("די"))
        return list

    }
}