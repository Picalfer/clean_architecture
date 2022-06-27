package com.example.clean_architecture.domain.repository

import com.example.clean_architecture.domain.models.SaveUserNameParam
import com.example.clean_architecture.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}