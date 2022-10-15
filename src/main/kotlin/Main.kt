import kotlin.collections.*
import kotlin.io.*
import kotlin.math.abs
import kotlin.text.*


// 4. Example -> A very BigSum
private fun aVeryBigSum(ar: Array<Long>): Long {
    var sum: Long = 0L
    ar.forEach {
        sum += it
        println(it)
    }

    /* Learned :
       Kotlin'de sayıların okunabilirliğini arttırmak için _ ile ayırabiliriz. 3_000_000_000
       Tek başına return'den oluşan fonksiyonlar varsa bunları tek satırda yazabiliriz.
       fun solveMeFirst(a:Int,b:Int): Int = a + b  ->  [ = a + b ] = [ return a +b ]
       Kotlin Compiler a + b nin bir integer olduğunu anlayabilir. Return tipini belirtmesekte çalışacaktır.
    */

    /* main()
    val arCount = readLine()!!.trim().toInt()
    val ar = readLine()!!.trimEnd().split(" ").map{ it.toLong() }.toTypedArray()
    val result = aVeryBigSum(ar)
    println(result)
    */
    return sum
}

// 5. Example -> Diagonal Difference
private fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var leftToRightDiagonal = 0
    var rightToLeftDiagonal = 0

    for (i in arr.indices) {
        leftToRightDiagonal += arr[i][i]
    }

    for (j in arr.indices) {
        rightToLeftDiagonal += arr[j][arr.size - j - 1]
    }

    /* Learned :
       abs() parametre farklarının mutlak değerini bize döndürür.
       for (i in 0 until n) { } kısa hali : (0 until n).sumOf { it -> } şeklindedir. it herbir elemandaki indexleri verir.
    */

    /* main()
    val n = readLine()!!.trim().toInt()
    val arr = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })
    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }
    val result = diagonalDifference(arr)
    println(result)
    */

    return  abs(leftToRightDiagonal - rightToLeftDiagonal)
}

// 6. Example -> Plus Minus
private fun plusMinus(array: Array<Int>) : Unit {
    var positiveCounter = array.count { it > 0 }
    var negativeCounter = array.count { it < 0}
    var zeroCounter = array.count { it == 0 }

    /*array.forEach {
        if (it > 0) positiveCounter += 1
        if (it < 0) negativeCounter += 1
        if (it == 0) zeroCounter += 1
    }*/ // array.count {} sonrası foreach'e gerek yok.

    println(String.format("%.6f", positiveCounter/array.size)) // Virgül sonrası 6 basamak yazdırır.
    println(String.format("%.6f", negativeCounter/array.size)) // Virgün sonrası 6 basamak yazdırır.
    println(String.format("%.6f", zeroCounter/array.size)) // Virgül sonrası 6 basamak yazdırır.

    /* Learned :
       Sayilari formatlayabiliriz.
       String.format("%.6f", positiveCounter/array.size) bu şekilde virgülden sonra 6 basamak yazdırır.
       array.count {şart} ile şart sağlandığı sürece count bir artacaktır.
    */

    /* Main
       plusMinus(arrayOf(-1,1,0,2,1))
    */
}

// 7. Example -> Staircase
private fun staircase(n : Int) : Unit {

    for (i in 1..n) {
       // for (j in 0 until n-i-1) print(" ")
       // repeat(n-i) { print(" ") }
       // for (k in 0..i) print("#")
       // repeat(i) { print("#") }
        println(" ".repeat(n-i) + "#".repeat(i))
    }

    /* Learned :
       Döngülerde i,j gibi değişkenleri döngü içinde kullanmıyorsak,
       repeat(tekrarsayısı) metedu ile tekrar etmesini sağlayabiliriz.
       repeat'i stringler üzerindede kullanabiliriz. Bir stringi repeat(tekrar) ile kullanarak tekrar ettirebiliriz.
       println("deneme".repeat(6)) 6 kere tekrarlanır.
    */

    /* Main
       staircase(5)
    */

}

// 8. Example -> Mini Max Sum
private fun miniMaxSum(arr : Array<Int>): Unit {

    val minimumOfArray = arr.min()
    val maximumOfArray = arr.max()
    val sumOfArrayElements = arr.map { it.toLong() }.sum()
    val minimumSum = sumOfArrayElements - maximumOfArray
    val maximumSum = sumOfArrayElements - minimumOfArray
    print("$minimumSum $maximumSum")

    /* Learned :
       array.map {it -> it.toLong()}.sum() ile arrayin tüm elemanlarını longa çevirip sonrasında toplayabiliriz.
       array.sumOf{it -> it.long()} yukarıdaki ile aynı işlemi yapmaktadır.
       array max(), min() fonksiyonları :
       .min() ve .max() fonksiyonları Kotlin 1.4 itibariyle .minOrNull() ve .maxOrNull() olarak değişti.
       Çünkü boş diziler üzerinde çalıştırıldıklarında exception throw etmek yerine null dönüyorlardı.
       İsmin yanıltıcı olabileceği düşünülerek minOrNull() ve maxOrNull() olarak güncellendiler.
    */

    /* Main :
       miniMaxSum(arrayOf(1,2,3,4,5))
    */

}





fun main() {
    miniMaxSum(arrayOf(1,2,3,4,5))

}