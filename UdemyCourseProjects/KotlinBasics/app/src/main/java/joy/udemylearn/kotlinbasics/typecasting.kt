package joy.udemylearn.kotlinbasics

import kotlin.math.floor

fun main()
{
    var stringList:List<String> = listOf("Joy", "Karmoker", "Denis")
    var mixedList:List<Any> = listOf("Joy", 2, 400.0, "Karmoker", "Denis", 5)
    for(value in mixedList)
    {
        if(value is Int)
        {
            println("Integer: $value")
        }

        else if(value is Double)
        {
            println("Double : $value with floor value ${floor(value)}")
        }

        else if(value is String)
        {
            println("Length of string is ${value.length}")
        }

        else
        {
            println("Unknown data type")
        }
    }

    val obj1:Any = "I have a dream"
    if(obj1 !is String)
    {
        println("Not a string")
    }
    else
    {
        println("Found a string of length ${obj1.length}")
    }

    //Unsafe
    var str1:String = obj1 as String;
    println(str1.length)

    //Safe
    val obj2:Any = 567
    var str2: String? = obj2 as? String
    println(str2)
}