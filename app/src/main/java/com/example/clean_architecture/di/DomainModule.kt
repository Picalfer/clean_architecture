package com.example.clean_architecture.di

import com.example.clean_architecture.domain.usecase.GetUserNameUseCase
import com.example.clean_architecture.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}