package com.example.clean_architecture.data.storage

import com.example.clean_architecture.data.storage.models.User

interface UserStorage {

    fun save(user: User) : Boolean

    fun get() : User
}