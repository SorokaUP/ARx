package com.profitmed.arx.presenter

import com.github.terrakok.cicerone.Router
import com.profitmed.arx.AndroidScreens
import com.profitmed.arx.model.GithubUser
import com.profitmed.arx.model.GithubUsersRepo
import com.profitmed.arx.view.IUserItemView
import com.profitmed.arx.view.IUserListPresenter
import com.profitmed.arx.view.UsersView
import moxy.MvpPresenter

class UsersPresenter(val usersRepo: GithubUsersRepo, val router: Router) : MvpPresenter<UsersView>() {
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((IUserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    fun openUser(user: GithubUser) {
        router.navigateTo(AndroidScreens().user(user))
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            openUser(usersRepo.getUsers()[itemView.pos])
        }
    }

    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}
