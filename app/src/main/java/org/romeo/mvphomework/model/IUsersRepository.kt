package org.romeo.mvphomework.model

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.Subject
import org.romeo.mvphomework.model.entities.User

interface IUsersRepository {
    val getUserObservable: Observable<List<User>>

    fun getUsersSubject(): Subject<List<User>>

    fun addNewUser(user: User)
}