package org.romeo.mvphomework.model

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import org.romeo.mvphomework.model.entities.User

object UsersRepository : IUsersRepository {
    private val users = mutableListOf(
        User("User1"),
        User("User2"),
        User("User3"),
    )

    private val usersSubject = PublishSubject.create<List<User>>()

    override val getUserObservable: Observable<List<User>>
        get() = Observable.just(users)

    override fun getUsersSubject(): Subject<List<User>> = usersSubject

    //Only for practice with Rx
    override fun addNewUser(user: User) {
        users.add(user)
        usersSubject.onNext(users)
    }
}