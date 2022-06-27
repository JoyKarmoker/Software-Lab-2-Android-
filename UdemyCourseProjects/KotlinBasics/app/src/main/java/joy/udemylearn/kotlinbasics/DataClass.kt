package joy.udemylearn.kotlinbasics

data class User(val id:Long, var name:String)

fun main()
{
    var user1 = User(1, "Joy")
    println(user1.name)
    var user2 = User(1, "karmoker")
    println(user1.equals(user2))
    println("User details: $user1")

    var updatedUser = user1.copy(name="Roy")
    println("User 1 is $user1")
    println("Updated user is $updatedUser")
    println("Component 2 of updated user is ${updatedUser.component2()}")

    var (id, name) = updatedUser
    println("Updates user's Id is $id, name is $name")

}