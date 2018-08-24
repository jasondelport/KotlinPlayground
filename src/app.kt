import java.util.*

fun main(args: Array<String>) {

    // https://www.youtube.com/watch?v=H_oGi8uuDpA

    println("Hello World")

    // casting, notice the single quotes
    println("A to Int -> ${'A'.toInt()}")

    println("hello".bounce(" world"))

    println("1 + 2 = ${1 + 2}")

    var str = " this is quote a oibf  string hellow world"
    var str1 = " this is quote "
    var str2 = " this is quote a oibf  string hellow world"
    var str3 = "ggggggggggggggg"

    println(str.dropLast(5))
    println("${str.subSequence(5, 10)}")
    println(str.compareTo(str1))
    println(str.compareTo(str2))
    println(str.compareTo(str3))
    println(str.equals(str1))


    val letters = 'A'..'Z'
    val numbers = 1..30

    for (x in letters) print(x)

    println("")

    for (x in numbers) print(x)

    println("")

    println(letters)
    println(numbers)


    var first = Singleton
    first.b = "hello singleton"
    var second = Singleton
    println(second.b)

    println(Singleton.bounce("test"))


    val rand = Random()
    val num = rand.nextInt(50) + 1

    var guess = 0

    while (num != guess) {
        guess += 1
    }

    println("num = $guess")


    var arr3: Array<Int> = arrayOf(4, 6, 2, 6, 4, 6, 4, 99)

    println(arr3)

    println(add1(3, 4))
    println(add2(3, 4))
    println(subtract(20))
    println(subtract(int2 = 5, int1 = 30))

    fun sayHello(name: String): Unit = println("Hello $name")

    sayHello("jason")

    fun nextVals(num: Int): Pair<Int, Int> {
        return Pair(num + 1, num + 2)
    }

    val (nxt1, nxt2) = nextVals(21)
    println("21 $nxt1 $nxt2")

    fun getSum(vararg nums: Int): Int {
        var sum = 0
        nums.forEach { n -> sum += n }
        return sum
    }

    println(getSum(1, 2, 3, 4, 5, 6, 7))

    // higher order functoins
    //A higher-order function is a function that takes functions as parameters, or returns a function.
    val nums4 = 1..20
    val evenList = nums4.filter { it % 2 == 0 }
    evenList.forEach { println(it) }
    evenList.forEach { x -> println(x) }

    //Lambda expressions and anonymous functions are 'function literals',
    // i.e. functions that are not declared, but passed immediately as an expression.
    fun makeFunc(num1: Int): (Int) -> Int = { num2 -> num1 * num2 }

    var add3 = makeFunc(3)

    println(add3(5))

    // could use some more examples here!!

    println("=============================================")

    // Lambda expression syntax
    val sumz = { x: Int, y: Int -> x + y }

    println(sumz(2, 3))

    val ints = arrayOf(-1, 2, -3, 4, -5, 6, -7, 8)

    // notice the use of 'it' here again
    println(ints.filter { it > 0 })


    val strings = arrayOf("hello", "jim", "jay", "hardold anj", "frank")
    val res = strings.filter { it.length == 5 }.sortedBy { it }.map { it.toUpperCase() }

    println(res)

    //closures
    // A lambda expression or anonymous function can access its closure,
    // i.e. the variables declared in the outer scope.
    val ints2 = arrayOf(-1, 2, -3, 4, -5, 6, -7, 8)
    var sumt = 0
    ints2.filter { it > 0 }.forEach {
        sumt += it
    }
    println("Total value - $sumt")


    // type-safe builder example

    class HTML {
        init {
            println("html init complete")
        }

        fun body() {
            println("in the body")
        }
    }

    fun html(init: HTML.() -> Unit): HTML {
        val html = HTML()  // create the receiver object
        html.init()        // pass the receiver object to the lambda
        return html
    }

    html {
        // lambda with receiver begins here
        body()   // calling a method on the receiver object
    }

    // tail recursive functions

    tailrec fun findFixPoint(x: Double = 1.0): Double = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))

    println(findFixPoint())

    println("=============================================")

    fun sumNumbers(vararg numbers: Int): Int {
        return numbers.sum()
    }

    val nums5 = intArrayOf(2, 3, 4)
    // the * operator is known as the Spread Operator in Kotlin
    val sum = sumNumbers(*nums5)
    println(sum) // prints '9'


    // Unit return type declaration is optional.
    fun printHello(name: String?): Unit {
        if (name != null)
            println("Hello ${name}")
        else
            println("Hi there!")
        // `return Unit` or `return` is optional
    }

    println(printHello("jason"))

    fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts) // ts is an Array
            result.add(t)
        return result
    }

    val a = arrayOf(1, 2, 3, "bob")
    val list = asList(-1, 0, *a, 4, "hello")

    println(list.toString())

    infix fun Int.shl(x: Int): Int {
        return x + 1
    }

    // calling the function using the infix notation
    println(1 shl 2) // omitting the dot and the parentheses for the call

    // is the same as
    println(1.shl(2))

    var lst = mutableListOf("hejb", 12, 98, 34, "hhh", true)
    lst = addToList("gege", lst)
    println(lst)

    val items = listOf(1, 2, 3, 4)
    println(items.filter { it % 2 == 0 })

    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
    println(readWriteMap["foo"])  // prints "1"

    // generics extension function
    fun <T> T.basicToString(): String {
        return this.toString()
    }

    var bool = true;
    println(bool.basicToString())

    // collection operators

    // reduce -> Accumulates value starting with the first element and applying operation
    // from left to right to current accumulator value and each element.
    var numbs = 1..20
    println(numbs.reduce { x, y -> x + y })

    println(numbs.fold(5) { x, y -> x + y }) // adds initial 5 to the above reduce

    println(numbs.any { it % 2 == 0 }) //returns boolean

    println(numbs.all { it % 2 == 0 }) //returns boolean

    println(numbs.filter { it > 17 }) //returns list

    println(numbs.map { it * 5 }) // returns new list with each item multiplied by 5


    var l1 = mutableListOf(1, 1, 2, 3, 4, 5, 6, 7, 8)
    val l2 = listOf(1, 2, 3, 4, 5, 6, 7)

    l1.add(22)

    println(l2.first())
    println(l2.last())
    println(l2[3])
    println(l2.subList(2, 5))
    println("size -> ${l2.size}")


    println(l1.removeIf { it == 1 })
    println(l1)
    println(l1.remove(2))
    println(l1)
    println("removed value -> ${l1.removeAt(5)}")
    println(l1)
    println("return Unit -> ${l1.clear()}")
    println(l1) // empty list

    println("=============================================")

    var map = mutableMapOf<Int, Any?>(1 to "Jii", 2 to true, 3 to 33)
    map[4] = false
    map.put(5, "gege")
    println(map)
    println(map[1])
    map.remove(2)
    println(map.size)
    println(map)
    for ((x, y) in map) {
        println("$x $y")
    }

    println("=============================================")

    // open keyword allows inheritance
    // By default, all classes in Kotlin are final and prevent inheritance
    open class Base(p: Int) {
        init {
            println("base init $p")
        }
    }

    class Derived(p: Int) : Base(p)

    var derived = Derived(22)


    var animal = Animal("jjas", 42)
    animal.info()
    println()

    var dog = Dog("bob", 45, "ukj")
    dog.info()


    var bird = Bird("tweeter", true)
    bird.fly(22)

    // NULLS
    // https://kotlinlang.org/docs/reference/null-safety.html

    // not allowed
    //var str21: String = null
    //allowed because of the question mark
    var str22: String? = null

    // question mark allows null to be returned
    fun returnNull(): String? {
        return null
    }

    println(returnNull())

    // !! operator forces it to compile and throw an NPE
    //println(str22!!.length)

    // elvis (?:) operator
    var nullVal: String? = returnNull() ?: "No Name"

    println(nullVal)

}

interface Flyable {
    var flies: Boolean
    fun fly(miles: Int)
}

class Bird constructor(var name: String, override var flies: Boolean = false) : Flyable {
    override fun fly(miles: Int) {
        if (flies) {
            println("$name flies $miles miles")
        }
    }
}


class Dog(name: String, weight: Int, var owner: String) : Animal(name, weight) {
    override fun info(): Unit {
        super.info()
        println(" + owner = $owner")
    }
}

// require example for classes
open class Animal(val name: String, weight: Int) {
    init {
        val regex = Regex(".*\\d+.*")
        require(!name.matches(regex)) { "Name can't contain a number" }
        require(weight > 0)
    }

    // can override this function
    open fun info(): Unit {
        print("name = $name")
    }
}


// generics example
fun <T> addToList(item: T, list: MutableList<T>): MutableList<T> {
    list.add(item)
    return list
}


// singleton
object Singleton {
    init {
        println("init complete")
    }

    var b: String? = null

    fun bounce(input: String): String {
        return "$input gogogogogo"
    }
}

// return types not needed for single line functions
fun add1(int1: Int, int2: Int) = int1 + int2

fun add2(int1: Int, int2: Int): Int = int1 + int2

// default values
fun subtract(int1: Int = 10, int2: Int = 2): Int = int1 - int2

// return types are needed in this case
fun String.bounce(input: String): String {
    return this.plus(input)
}