package com.example.clean_architecture.di

import com.example.clean_architecture.data.repository.UserRepositoryImpl
import com.example.clean_architecture.data.storage.UserStorage
import com.example.clean_architecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.clean_architecture.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}