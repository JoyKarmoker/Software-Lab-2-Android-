package joy.udemylearn.kotlinbasics

fun main()
{
    var myCar  =Car()
    myCar.maxSpeed = 1
    println("Owner is ${myCar.owner}")
    println("Brand is ${myCar.brand}")
    println("Color is ${myCar.color}")
    println("Max speed is ${myCar.maxSpeed}")
    println("Model is ${myCar.model}")

}

class Car()
{
    lateinit  var owner:String

    val color = "RED"
    var brand = "BMW"
    get()
    {
        return field.toLowerCase()
    }

    var maxSpeed = 250
    set(value){
        field = if(value>0) value else throw IllegalArgumentException("Max Speed can not be less than 0")
    }

    var model = "M5"
        private set

    init {
        owner = "JOY"
        model = "M3"
    }
}