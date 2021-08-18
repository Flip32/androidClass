package br.com.helloworld

import com.example.helloworld.User
import java.util.*

class Repository private constructor() {
    private var _users = mutableListOf<User>()
    val users: List<User>
        get() = _users

    val formattedUserNames: List<String>
        get() {
            return users.map { (firstName, lastName) ->
                if (lastName != null) {
                    if (firstName != null) {
                        "$firstName $lastName"
                    } else {
                        lastName
                    }
                } else {
                    firstName ?: "Unknown"
                }
            }
        }
            /*val userNames: MutableList<String> = ArrayList(users.size)

            for ((firstName, lastName) in users) {
                val name = if (lastName != null) {
                    if (firstName != null) {
                        "$firstName $lastName"
                    } else {
                        lastName
                    }
                } else {
                    firstName ?: "Unknown"
                }
                userNames.add(name)
            }
            return userNames*/


    companion object {
        private var INSTANCE: Repository? = null
        val instance: Repository?
            get() {
                if (INSTANCE == null) {
                    synchronized(Repository::class.java) {
                        if (INSTANCE == null) {
                            INSTANCE = Repository()
                        }
                    }
                }
                return INSTANCE
            }
    }

    // keeping the constructor private to enforce the usage of getInstance
    init {
        val user1 = User("Jane", "")
        val user2 = User("John")
        val user3 = User("Anne", "Doe")
        _users = ArrayList<User>()
        _users.add(user1)
        _users.add(user2)
        _users.add(user3)
    }
}