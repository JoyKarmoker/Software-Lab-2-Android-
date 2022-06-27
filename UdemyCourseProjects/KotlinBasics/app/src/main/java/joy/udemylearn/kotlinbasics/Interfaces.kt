package joy.udemylearn.kotlinbasics
fun main()
{

    var myBari = Bari(23.0, "A3", "Audi")
    var myEBari = ElectricBari(45.0,"M2", "Tesla", 85.0)
      myBari.drive(45.0)
      myEBari.drive(100.0)
    var res = myEBari.drive()
    println(res)
    res = myBari.drive()
    println(res)
    myBari.brake()
    myEBari.brake()

}

interface drivable{
    val maxSpeed:Double
    fun drive():String
    fun brake()
    {
        println("The Drivable is breaking")
    }
}

open class Bari(override  val maxSpeed:Double, val name:String, val brand:String) : drivable
{
    open var range = 0.0

    override fun drive():String
    {
        return "driving the interface drive"
    }

    fun extendRange(amount:Double)
    {
        if(amount > 0)
        {
            range += amount
        }
    }

    fun drive(distance:Double)
    {
        println("Drove for $distance KM")
    }

}

class ElectricBari(maxSpeed: Double, name: String, brand: String, batteryLife:Double) :Bari(maxSpeed, name, brand)
{
    override fun drive():String
    {
        return "Driving the range 590 km"
    }

    override  fun brake()
    {
        super.brake()
        println("Breakin inside electric bari")
    }
}