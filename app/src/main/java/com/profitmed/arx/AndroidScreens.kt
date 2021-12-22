package com.profitmed.arx

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.profitmed.arx.model.GithubUser
import com.profitmed.arx.view.UserFragment
import com.profitmed.arx.view.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(user: GithubUser) = FragmentScreen { UserFragment.newInstance(user) }
}