package com.profitmed.arx.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface UsersView : MvpView {
    fun init()
    fun updateList()
}