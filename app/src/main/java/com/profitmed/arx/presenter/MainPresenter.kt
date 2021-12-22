package com.profitmed.arx.presenter

import com.github.terrakok.cicerone.Router
import com.profitmed.arx.view.IMainView
import com.profitmed.arx.IScreens
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<IMainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}