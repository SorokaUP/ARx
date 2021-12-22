package com.profitmed.arx

import java.io.Serializable

class MainPresenter(private val view: IMainView): Serializable {
    private val model = CountersModel()

    fun counterClick(index: Int) {
        val nextValue = model.next(index)
        view.setButtonText(index, nextValue.toString())
    }

    fun getCurrent(index: Int): Int {
        return model.getCurrent(index)
    }
}