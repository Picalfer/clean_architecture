package com.example.clean_architecture.domain.usecase

import com.example.clean_architecture.domain.models.SaveUserNameParam
import com.example.clean_architecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) return true

        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}