package com.example.clean_architecture.data.repository

import com.example.clean_architecture.data.storage.models.User
import com.example.clean_architecture.data.storage.UserStorage
import com.example.clean_architecture.domain.models.SaveUserNameParam
import com.example.clean_architecture.domain.models.UserName
import com.example.clean_architecture.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        val user = mapToStorage(saveParam)

        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam) : User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User) : UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}