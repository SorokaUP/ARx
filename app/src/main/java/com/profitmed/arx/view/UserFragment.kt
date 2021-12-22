package com.profitmed.arx.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.profitmed.arx.App
import com.profitmed.arx.BackButtonListener
import com.profitmed.arx.databinding.FragmentUserBinding
import com.profitmed.arx.model.GithubUser
import com.profitmed.arx.model.GithubUsersRepo
import com.profitmed.arx.presenter.UserPresenter
import com.profitmed.arx.presenter.UsersPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment(val user: GithubUser) : MvpAppCompatFragment(), UserView, BackButtonListener {
    companion object {
        fun newInstance(user: GithubUser) = UserFragment(user)
    }

    val presenter: UserPresenter by moxyPresenter { UserPresenter(user, App.instance.router) }
    var adapter: UsersRVAdapter? = null

    private var vb: FragmentUserBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentUserBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.tvUserName?.text = user.login
    }

    override fun backPressed() = presenter.backPressed()
}