package com.tut.mytikunstructure.model

import com.tut.mytikunstructure.view.adapters.TikunItemType

data class TikunSentenceImpl(override var text: String, override var type: TikunItemType=TikunItemType.SENTENCE):TikunItem