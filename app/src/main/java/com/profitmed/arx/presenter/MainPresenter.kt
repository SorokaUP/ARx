package com.profitmed.arx.presenter

import com.github.terrakok.cicerone.Router
import com.profitmed.arx.model.CountersModel
import com.profitmed.arx.model.GithubUser
import com.profitmed.arx.model.GithubUsersRepo
import com.profitmed.arx.view.IMainView
import com.profitmed.arx.view.IScreens
import com.profitmed.arx.view.IUserItemView
import com.profitmed.arx.view.IUserListPresenter
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