package com.tut.mytikunstructure.model

import com.tut.mytikunstructure.view.adapters.TikunItemType

data class TikunHeaderImpl(override var text: String, override var type: TikunItemType=TikunItemType.HEADER):TikunItem {
}