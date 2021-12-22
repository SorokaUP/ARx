package com.profitmed.arx

import com.github.terrakok.cicerone.Screen
import com.profitmed.arx.model.GithubUser

interface IScreens {
    fun users(): Screen
    fun user(user: GithubUser): Screen
}