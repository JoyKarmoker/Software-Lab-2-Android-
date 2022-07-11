package joy.udemylearn.kotlinbasics

import kotlin.math.floor

fun main()
{
    val months = listOf("January", "February", "March")
    val mix = listOf(1, 2, 3, true, false, "Joy")
    //println(months.size)
    //println(mix[0])
//    for(month in months)
//    {
//        print(month)
//    }

    val additionalMonths = months.toMutableList()
    val newMonths = listOf("April", "May", "June")
    additionalMonths.addAll(newMonths)
    additionalMonths.add("July")
//    println(additionalMonths)

    val days = mutableListOf<String>("Mon", "Tue", "Wed")
    days.add("Thu")
    days[2] = "Sun"
    days.removeAt(1)
    val removeList = mutableListOf<String>("Mon", "Wed")
//    days.removeAll(removeList)
    days.removeAll(days)
//    println(days)

    val mixList = mutableListOf("Joy", "karmoker", 1)
    mixList.add("Roy")
    mixList.add(90)
    println(mixList)
    for(value in mixList)
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

}