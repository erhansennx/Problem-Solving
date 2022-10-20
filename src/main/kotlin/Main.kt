import kotlin.collections.*
import kotlin.io.*
import kotlin.math.abs
import kotlin.text.*


//  4. Example -> A very BigSum
private fun aVeryBigSum(ar: Array<Long>): Long {
    var sum: Long = 0L
    ar.forEach {
        sum += it
        println(it)
    }
    return sum
}

//  5. Example -> Diagonal Difference
private fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var leftToRightDiagonal = 0
    var rightToLeftDiagonal = 0

    for (i in arr.indices) {
        leftToRightDiagonal += arr[i][i]
    }

    for (j in arr.indices) {
        rightToLeftDiagonal += arr[j][arr.size - j - 1]
    }

    return  abs(leftToRightDiagonal - rightToLeftDiagonal)
}

//  6. Example -> Plus Minus
private fun plusMinus(array: Array<Int>) : Unit {
    var positiveCounter = array.count { it > 0 }
    var negativeCounter = array.count { it < 0}
    var zeroCounter = array.count { it == 0 }

    println(String.format("%.6f", positiveCounter/array.size))
    println(String.format("%.6f", negativeCounter/array.size))
    println(String.format("%.6f", zeroCounter/array.size))
}

//  7. Example -> Staircase
private fun staircase(n : Int) : Unit {
    for (i in 1..n) {
        println(" ".repeat(n-i) + "#".repeat(i))
    }
}

//  8. Example -> Mini Max Sum
private fun miniMaxSum(arr : Array<Int>): Unit {
    val minimumOfArray = arr.min()
    val maximumOfArray = arr.max()
    val sumOfArrayElements = arr.map { it.toLong() }.sum()
    val minimumSum = sumOfArrayElements - maximumOfArray
    val maximumSum = sumOfArrayElements - minimumOfArray
    print("$minimumSum $maximumSum")
}

//  9. Example -> Birthday Cake Candles
private fun birthdayCakeCandles(candles: Array<Int>) : Int {
    var max = 0
    var countOfArray = candles[0]

    for (candle in candles) {
        if (candle == max) {
            countOfArray += 1
        }
        if (candle > max) {
            max = candle
            countOfArray = 1
        }
    }

    return countOfArray
}

// 10. Example -> Time Conversion
private fun timeConversion(s: String): String {

    var hour = s.take(2).toInt()
    var middle = s.substring(2, 8)
    var amPm = s.takeLast(2)

    if (hour == 12 && amPm == "AM") {
        hour = 0
    }

    if (hour < 12 && amPm == "PM") {
        hour += 12
    }

    return "${hour.toString().padStart(2, '0')}$middle"
}

// 11. Example -> Grading Students
private fun gradingStudents(grades: Array<Int>): Array<Int> {

    return grades.map {
        when {
            it < 38 -> it
            it % 5 == 3 -> it+2
            it % 5 == 4 -> it+1
            else -> it
        }
    }.toTypedArray()

}

// 12. Example -> Apple and Orange
private fun countApplesAndOranges(s: Int, t: Int, appleTreeLocation:Int, orangeTreeLocation: Int, apples: Array<Int>, oranges: Array<Int>): Unit {

    var countApple = 0
    var countOrange = 0

    apples.forEach {
        val range = appleTreeLocation + it
        if (range in s..t) {
            countApple++
        }
    }

    oranges.forEach {
        val range = orangeTreeLocation + it
        if (range in s..t) {
            countOrange++
        }
    }

    println("$countApple \n$countOrange")

}

// 13. Example -> Number Line Jumps
private fun kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String {

    return when {
        (x1 < x2 && v1<=v2) -> "NO"
        (x2 - x1) % (v2 - v1) == 0 ->"YES"
        else -> "NO"
    }

}

// 14. Example -> Between Two Sets
private fun getTotalX(a: Array<Int>, b: Array<Int>): Int {

    var count = 0
    val firstArrayMax = a.max().toInt()
    val secondArrayMin = b.min().toInt()

    for (i in firstArrayMax..secondArrayMin) {
        if (a.all { i % it == 0 } && b.all { it % i == 0 }) count++
    }

    return count
}

fun main() {
    print(getTotalX(arrayOf(2,6), arrayOf(24,36)))
}