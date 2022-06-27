package joy.udemylearn.kotlinbasics

fun main()
{
    var joy = Person("Joy", "karmoker", 56)
    joy.hobby = "Cricket"
    joy.age = 22
    joy.stateHobby()
    joy.stateAge()

    //var jhon = Person()
    //var jhonDenver = Person(lastName = "Denver")
}

class Person(firstName:String = "Jhon", lastName:String = "Doe")
{
    var age:Int? = null
    var hobby = "Watching netflix"
    var firstName:String = "Jhon"
    init
    {
        println("Person Created with name $firstName $lastName")
        this.firstName = firstName
    }

    //Secondary constructor
    constructor(firstName: String, lastName: String, age:Int) :this(firstName, lastName)
    {
        this.age = age;
        println("Person Created with $firstName $lastName $age")

    }
    fun stateHobby()
    {
        println("$firstName's hobby is $hobby")
    }

    fun stateAge()
    {
        println("Age of $firstName is $age")
    }
}