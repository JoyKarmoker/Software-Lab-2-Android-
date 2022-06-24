package joy.udemylearn.kotlinbasics

fun main(){
    /*
    //This is  single line comment
    //TODO: Create something here
    val name = "Joy"
//    print("Hello $name")

    val myint:Int = 32
    val myByte:Byte = 8
    val myShort: Short = 16
    val myLong:Long =64

    val myFloat:Float = 32.37F
    val myDouble:Double = 64.57
//     print(" Int $myint Mybite: $myByte Myshort: $myShort")

    val mystr:String = "Hello world!"
    var mychar = 'a'
    mychar = mystr[0]
//    print(" My Char: $mychar")
    var mychara = 'a'
    var lastchar = mystr[mystr.length -1]
//    print("Last Char : $lastchar and the length is ${mystr.length}")

//    println("Is -5 lower equal 3 ${-5<= 3}")
    var month = 1
    when(month)
    {
        in 3..5 -> println("summer")
        in 6..8 -> println("Rainy")
        in 9..11 -> println("Fall")
        12, 1, 2 -> println("Winter")

        else -> {
            println("Invalid Month")

        }
    }

    var x:Any = 13.34f
    when(x)
    {
        is Int -> println("X is Int")
        is Double -> println("X is Double")
        is Float -> println("X is float")
        is String -> println("X is string")
        else -> println("X is none of the above")
    }

    for(num in 1..10 step 3)
    {
        print("$num ")
    }
    print("\n")

    for(i in 1 until 10)
    {
        print("$i ")
    }

    print("\n")

    for(i in 10 downTo 1 step 2)
    {
        print("$i ")
    }
    print("\n")

    var res = add(4, 5)
    println("Result is $res")

    var av = avg(4, 4)
    println("Result is $av")
     */

//    var name:String = "Joy";
    //name = null //Compilation Error

    var nullableName: String? = "KArmoker"
    //nullableName = null

//    var len1 = name.length;
    var len2 = nullableName?.length;
    //println(nullableName?.toLowerCase())
//    println(nullableName?.length)

    val name = nullableName ?: "Guest"
    println(name)
    println(nullableName!!.toLowerCase())

    /*
    if(nullableName != null)
    {
        println(nullableName?.length)
    }
    */

}


fun add(a:Int, b:Int):Int{
    return a+b;
}

fun avg(a: Int, b:Int):Float{
    return (a.toFloat()+b)/2
}