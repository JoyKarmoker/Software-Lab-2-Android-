package joy.udemylearn.kotlinbasics

fun main()
{
    val fruits = setOf("Orange", "Mango", "Grape", "Apple", "Orange")
    //println(fruits.size)
    //println(fruits)
    val newFruits = fruits.toMutableSet()
    newFruits.add("Grape")
    newFruits.add("Apple")
    newFruits.add("Water melon")
    //println(newFruits)

    val days = mapOf(1 to "Monday", 2 to "Tuesday", 3 to "Wednesday", 4 to "Thursday")
    //println(days.size)
    //println(days)
    //println(days[2])
    days.toSortedMap()
    for(key in days.keys)
    {
        println("$key to ${days[key]}")
    }
}