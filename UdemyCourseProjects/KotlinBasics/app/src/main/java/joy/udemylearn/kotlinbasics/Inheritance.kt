package joy.udemylearn.kotlinbasics

fun main()
{
    /*var car = Jar()
    println("Car max speed is ${car.maxSpeed}")
    car.maxSpeed = 40
    println("Car max speed is ${car.maxSpeed}")
    println("Wheels in car is ${car.wheels}")
    car.move()
    car.drive()*/

    var myGari = Gari("A3", "Audi")
    var myEGari = ElectricGari("M2", "Tesla", 85.0)
    myGari.drive(45.0)
    myEGari.drive(100.0)
    println("Gari range = ${myGari.range}")
    println("EGari range = ${myEGari.range}")
    myEGari.drive()
    myEGari.drive("Padma")

}

open class Gari(val name:String, val brand:String)
{
    open var range = 0.0
    fun extendRange(amount:Double)
    {
        if(amount > 0)
        {
            range += amount
        }
    }

    open fun drive(distance:Double)
    {
        println("Drove for $distance KM")
    }

    fun drive(road:String)
    {
        println("Driving on the road $road")
    }

}

class ElectricGari(name: String, brand: String, batteryLife:Double) :Gari(name, brand)
{
    override var range = 100.0

    override fun drive(distance:Double)
    {
        println("Driving my electric car for $distance km")
    }

    fun drive()
    {
        println("Different from parent drive function")
    }

}