package com.example.clean_architecture.domain.usecase

import com.example.clean_architecture.domain.models.UserName
import com.example.clean_architecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}