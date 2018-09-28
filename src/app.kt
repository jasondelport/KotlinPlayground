
import java.util.*
import kotlin.concurrent.thread
import kotlin.concurrent.timerTask

fun main(args: Array<String>) {

    // https://www.youtube.com/watch?v=H_oGi8uuDpA

    // https://blog.philipphauer.de/idiomatic-kotlin-best-practices/

    println("Hello World")

    val numbers = 1..30

    // nice way to handle nulls and auto casting using the ?. and ?: operators
    // very succinct
    fun doit(name: String?) {
        println("Size is ${name?.length ?: 0}")
    }

    doit("Harry")
    doit(null)

    // imperative vs functional programming
    // imperative -> you tell what to do and how to do it
    // declarative -> tell what and not how
    // functional -> declarative + higher order functions

    //Imperative programming: telling the "machine" how to do something, and as a result what you want to happen will happen.
    //Declarative programming: telling the "machine"1 what you would like to happen, and let the computer figure out how to do it.

    println(
            numbers.filter { e -> e % 2 == 0}
                    .map { it * 2}
                    .reduce { total, e -> total + e }) // 480

    // http://kotlinlang.org/docs/reference/basic-types.html
    // above includes types, casting, arrays, operations, string literals, string templates

    // casting, notice the single quotes
    println("A to Int -> ${'A'.toInt()}")

    val singNum = "35"
    val singNumInt = singNum.toIntOrNull()
    println(singNumInt)
    val singnum1 = 36
    var singnumStr1 = singnum1.toString()
    if (singnumStr1 is String) println("is a string")

    //.bounce is a custom extension to the string object
    println("hello".bounce(" world"))

    fun String.shout() = toUpperCase()

    println("shout".shout())
    
    // multiline comment
    var s = """Hello
            World"""
    println(s)

    // kotlin string templates can contain logic including if statements
    println("1 + 2 = ${1 + 2}")
    println("1 + 2 = ${if ((1 + 2) > 2) "this" else "that"}")

    println("=============================================")

    var str = " this is quote a oibf  string hellow world"
    var str1 = " this is quote "
    var str2 = " this is quote a oibf  string hellow world"
    var str3 = "ggggggggggggggg"


    // In Kotlin, if is an expression, i.e. it returns a value and a statement
    // Therefore there is no ternary operator (condition ? then : else)

    /*
    // Traditional usage
    var max = a
    if (a < b) max = b

    // With else
        var max: Int
        if (a > b) {
            max = a
        } else {
            max = b
        }

    // As expression
        val max = if (a > b) a else b


     when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> { // Note the block
            print("x is neither 1 nor 2")
        }
    }

    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }


    when (x) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        parseInt(x) -> print("s encodes x")
        x.isGreatNumber() -> print("great number!!")
        is String -> print("is a string")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }
    */

    val abc = arrayOf(1, 2,3, 20, 27, 28, 30, "bob", intArrayOf(1,2,3,4), true)

    // TYPES
    // Any type represents the super type of all non-nullable types.
    // Unit is the equivalent to void, It is returned implicitly. No need of a return statement.
    // Nothing does not exist in Java. It is used when a function will never terminate normally and therefore a return value has no sense.
    fun <T> isMyNumber(x: T) : Any? {
        return if (x == 28) x
        else null
    }

    // think of when statements as pattern matching

    // https://www.programiz.com/kotlin-programming/when-expression

    for (x in abc) {
        when(x) {
            1 -> println("one")
            2,3 -> println("two or three")
            in 4..25 -> println("in 4 to 25 range")
            is String -> println("is string with length ${x.length}")
            isMyNumber(x) -> println("my number!!!")
            is Int -> println("is int")
            is IntArray -> println("is int array -> ${x.sum()}")
            else -> println("other -> $x")
        }
    }


    println(str.dropLast(5))
    println("${str.subSequence(5, 10)}")
    println(str.compareTo(str1))
    println(str.compareTo(str2))
    println(str.compareTo(str3))

    // equality
    // Structural equality == (is this preferred over equal()?)
    // Referential equality === (two references point to the same object);

    println("referential test -> ${if (str === str1) "same strings" else "different strings"}")

    println(str == str1)
    println(str.equals(str1, true)) // ignores case


    // ranges
    val letters = 'A'..'Z'
    //val mixed = 'A'..25 incorrect, can't mix types

    for (x in letters) print(x)

    println("")

    for (x in numbers) print(x)

    println("")

    println(letters)
    println(numbers)


    // singleton declared outside of the main method
    var first = Singleton
    first.b = "hello singleton"
    var second = Singleton
    println(second.b)

    // first and second are same object
    println("referential test -> ${if (first === second) "same object" else "different objects"}")

    println(Singleton.bounce("test"))


    val rand = Random()
    val num = rand.nextInt(50) + 1

    var guess = 0

    while (num != guess) {
        guess += 1
    }

    println("guessed random number = $guess")


    var arr3: Array<Int> = arrayOf(4, 6, 2, 6, 4, 6, 4, 99)
    println("array ${arr3.contentToString()}")
    var arr33 = arrayOf(4, 6, 2, 6, 4, 6, 4, 99)
    println("array ${arr33.contentToString()}")

    // functions at the bottom of the file
    println(add1(3, 4)) // 7
    println(add2(3, 4)) // 7
    println(subtract(20))  // 18
    println(subtract(int2 = 5, int1 = 30)) // 25 -> defaults are 10 and 2

    // If a function does not return any useful value, its return type is Unit.
    // Unit is a type with only one value - Unit.
    // This value does not have to be returned explicitly:

    fun printHelloName1(name: String): Unit {
        println("Hello $name")
        return Unit // `return Unit` or `return` is optional
    }

    // same as...

    fun printHelloName4(name: String): Unit {
        println("Hello $name")
    }

    // same as....

    fun printHelloName2(name: String) {
        println("Hello $name")
    }

    // same as...

    fun printHelloName3(name: String): Unit = println("Hello $name")

    printHelloName1("Jason")
    printHelloName4("Jason")
    printHelloName2("Jason")
    printHelloName3("Jason")

    fun nextVals(num: Int): Pair<Int, Int> {
        return Pair(num + 1, num + 2)
    }

    val (nxt1, nxt2) = nextVals(21)
    println("21 $nxt1 $nxt2") // 21 22 23

    fun getSum(vararg nums: Int): Int {
        var sum = 0
        nums.forEach { n -> sum += n }
        return sum
    }

    println(getSum(1, 2, 3, 4, 5, 6, 7)) // 28

    val nums4 = 1..20
    val evenList = nums4.filter { it % 2 == 0 }
    // notice use of 'it', can only be applied to single variable functions
    evenList.forEach { println(it) }

    //same as....

    evenList.forEach { x -> println(x) }

    // higher order functions
    // A higher-order function is a function that takes functions as parameters, or returns a function.

    fun makeFunc(num1: Int): (Int) -> Int = { num2 -> num1 * num2 }

    var add3 = makeFunc(3)

    println(add3(5))

    // could use some more examples here!!

    println("=============================================")

    // Lambda expressions and anonymous functions are 'function literals',
    // i.e. functions that are not declared, but passed immediately as an expression.

    // Lambda expression syntax
    val sumz = { x: Int, y: Int -> x + y }

    println(sumz(2, 3)) // 5

    val square = { number: Int -> number * number }
    square(3) // 9


    val oneVar: (Int) -> Int = { three -> three }
    val multiple: (String, Int) -> String = { strng, int -> strng + int }
    val noReturn: (Int) -> Unit = { num9 -> println(num9) }

    println(oneVar(5)) // 5
    println(multiple("hello ", 5)) // hello 5
    noReturn(4) // 4

    val ints = arrayOf(-1, 2, -3, 4, -5, 6, -7, 8)

    // notice the use of 'it' here again
    println(ints.filter { it > 0 }) // [2, 4, 6, 8]


    val strings = arrayOf("hello", "jim", "jay", "hardold anj", "frank")
    val res = strings.filter { it.length == 5 }.sortedBy { it }.map { it.toUpperCase() }

    println(res) // [FRANK, HELLO]

    //closures
    // A lambda expression or anonymous function can access its closure,
    // i.e. the variables declared in the outer scope.
    val ints2 = arrayOf(-1, 2, -3, 4, -5, 6, -7, 8)
    var sumt = 0
    ints2.filter { it > 0 }.forEach {
        sumt += it
    }
    println("Total value - $sumt") //20


    // type-safe builder example, how do these compare in inline functions?

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



    /*
    https://kotlinlang.org/docs/reference/lambdas.html

    // not the code: type is a function with ()
    inline fun debug(code: () -> Unit){
      if (BuildConfig.BUILD_TYPE == "debug"){
        code()
      }
    }

    debug{
        showDebugTools()
    }


     */

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


    // generic list example

    fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts) // ts is an Array
            result.add(t)
        return result
    }

    val a = arrayOf(1, 2, 3, "bob")
    val list = asList(-1, 0, *a, 4, "hello")

    // print contents of lists with toString()
    // print contents of array with contentToString()
    println(list.toString()) // [-1, 0, 1, 2, 3, bob, 4, hello]

    infix fun Int.shld(x: Int): Int {
        return x + 1
    }

    // calling the function using the infix notation
    println(1.shld(2)) // 4

    // is the same as...

    println(1 shld 2) // omitting the dot and the parentheses for the call


    var lst = mutableListOf("hejb", 12, 98, 34, "hhh", true)
    lst = addToList("gege", lst)
    println(lst) // [hejb, 12, 98, 34, hhh, true, gege]

    val items = listOf(1, 2, 3, 4)
    println(items.filter { it % 2 == 0 })

    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
    println(readWriteMap["foo"])  // prints "1"

    // generics extension function

    fun <T> T.basicToString(): String {
        return this.toString()
    }

    var bool = true
    println(bool.basicToString()) // true

    // collection operators

    // reduce -> Accumulates value starting with the first element and applying operation
    // from left to right to current accumulator value and each element.
    val numbs = 1..20
    println(numbs.reduce { x, y -> print("$x "); x + y })  // 210
    // 1 3 6 10 15 21 28 36 45 55 66 78 91 105 120 136 153 171 190 210

    println(numbs.count()) // 20

    numbs.forEachIndexed { index, value -> if (index == 0) println("position $index contains a $value") }

    println(numbs.count { it % 2 == 0 }) // 10

    // fold is same as reduce but contains as initial value
    println(numbs.fold(5) { x, y -> x + y }) // 215 - adds initial 5 to the above reduce

    println(numbs.any { it % 2 == 0 }) //returns boolean -> true

    println(numbs.all { it % 2 == 0 }) //returns boolean -> false

    println(numbs.filter { it > 17 }) //returns list -> [18, 19, 20]

    println(numbs.map { it * 5 }) // returns new list with each item multiplied by 5
    // [5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100]

    val arrrr6 = arrayOf(3, 4, 5, null, 10)

    println(arrrr6.map { if (it != null) it * 3 else null }) // [9, 12, 15, null, 30]
    println(arrrr6.mapNotNull { if (it != null) it * 3 else null }) // [9, 12, 15, 30]

    // ALSO: drop, dropWHile, take, slice

    val deepArray = arrayOf(
            arrayOf(1),
            arrayOf(2, 3),
            arrayOf(4, 5, 6)
    )

    println(deepArray) // [[Ljava.lang.Integer;@cc34f4d
    println(deepArray.contentToString()) // [[Ljava.lang.Integer;@cc34f4d, [Ljava.lang.Integer;@17a7cec2, [Ljava.lang.Integer;@65b3120a]
    println(deepArray.flatten()) // [1, 2, 3, 4, 5, 6]


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


    // maps

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

    println(returnNull()) // null

    // elvis (?:) operator
    var nullVal: String? = returnNull() ?: "No Name"

    println(nullVal) // No name

    //val l: Int = if (b != null) b.length else -1

    // becomes

    //val l = b?.length ?: -1

    // safe calls using ?.
    // bob?.department?.head?.name

    // If either `person` or `person.department` is null, the function is not called:
    // person?.department?.head = managersPool.getManager()





    // using inline functions as declarative code
    justTry {
        var tNum = 22
    }

    // built in kotlin inline function
    thread {
        println("printed in a separate thread")
    }
    println("printed in the main thread")

    // A daemon thread is a thread that does not prevent the JVM from
    // exiting when the program finishes but the thread is still running.

    // true ends the process without waiting for the timer,
    // false keeps the process open until the timer ends

    val timer = Timer(false)

    fun printMe() {
        println("print me!!!!")
        timer.cancel()
    }

    timer.schedule(timerTask { printMe() }, 2000)

    // !! operator forces it to compile and throw an NPE
    println("this print null -> ${str22?.length}") // null
    println(str22!!.length) // throws exception

}

inline fun <T> justTry(block: () -> T) = try {
    block()
} catch (e: Throwable) {
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