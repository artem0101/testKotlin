package third

import java.lang.IllegalArgumentException

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
    }
//    when {
//        user.name.isEmpty() -> throw IllegalArgumentException("Can't save user ${user.id}: empty name.")
//        user.address.isEmpty() -> throw IllegalArgumentException("Can't save user ${user.id}: empty address.")
//    }
}

fun main() {
    saveUser(User(1, "", ""))
}