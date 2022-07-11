package joy.udemylearn.kotlinbasics

import android.net.eap.EapSessionConfig

fun main()
{
//    val numbers:IntArray = intArrayOf(1, 2, 3, 4, 5);
//      val numbers = intArrayOf(1, 2, 3, 4, 5)
    val numbers = arrayOf(1, 2, 3, 4, 5)
//    println(numbers)
    println("Initial values ${numbers.contentToString()}")
//
//    for (element in numbers)
//    {
//        println("${element+2}")
//    }
    numbers[0] = 7
    numbers[1] = 8
    numbers[2] = 9
    numbers[3] = 10
    numbers[4] = 11

    println("Final Values of integer array ${numbers.contentToString()}")

    val numbersD = arrayOf(1.0, 2.0, 3.0)
    numbersD[0] = 9.0
    numbersD[1] = 8.0
    println("Double Array ${numbersD.contentToString()}")

    val cities = arrayOf("Dhaka", "Khulna")
    println("String array ${cities.contentToString()}")

    val fruits = arrayOf(Fruit("Apple", 2.5), Fruit("Grape", 3.0))
    println("Class array ${fruits.contentToString()}")

    for(fruit in fruits)
    {
        println("${fruit.name}")
    }
    for(index in fruits.indices)
    {
        println("${fruits[index].name} is in the index $index")
    }

    val mix = arrayOf("Dhaka", "Khulna", 1, 2, 3, 4, Fruit("Banana", 12.0))
    println("Mix array is ${mix.contentToString()}")

}

data class Fruit(val name: String, val price:Double)