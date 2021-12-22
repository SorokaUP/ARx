package com.profitmed.arx.presenter

import com.github.terrakok.cicerone.Router
import com.profitmed.arx.model.GithubUser
import com.profitmed.arx.model.GithubUsersRepo
import com.profitmed.arx.view.IUserItemView
import com.profitmed.arx.view.IUserListPresenter
import com.profitmed.arx.view.UserView
import com.profitmed.arx.view.UsersView
import moxy.MvpPresenter

class UserPresenter(val user: GithubUser, val router: Router) : MvpPresenter<UserView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        //loadData()
    }

    /*fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }*/

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}