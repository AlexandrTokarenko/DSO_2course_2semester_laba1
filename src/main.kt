fun main() {
    val N = 10
    var arr = IntArray(100_000) {(0 until 100_000+1000*N).random()}

    calculate(arr)

    println("Найменший індекс елементу масиву, що дорівнює 1010: ${linearSearch(arr,1000 + N)}")

    var (mid, count) = findBinaryAndCalculate(arr,1000 + N)
    println("Кількість операцій порівнянь для НЕвпорядкованого масиву: $count")

    val start: Long = System.currentTimeMillis()
    sort(arr)
    val finish: Long = System.currentTimeMillis()
    println("Час роботи алгоритму сортування масиву з 100 000 елементів: ${finish - start}")

    var arr2 = IntArray(200_000) {(0 until 100_000+1000*N).random()}
    val start2: Long = System.currentTimeMillis()
    sort(arr2)
    val finish2: Long = System.currentTimeMillis()
    println(
        "Різниця роботи алгоритму сортування для масивів " +
                "з 200 000 та 100 000 = ${(finish2 - start2) - (finish - start)}",
    )
    count = findBinaryAndCalculate(arr,1000 + N).second
    mid = findBinaryAndCalculate(arr,1000 + N).first
    println("Найменший індекс елементу масиву, що дорівнює 1010, використовуючи бінарний пошук: $mid")
    println("Кількість операцій порівнянь для впорядкованого масиву: $count")
}

fun sort(arr: IntArray) {

    var temp: Int
    var item: Int
    for (i in 1 until arr.size) {

        temp = arr[i]
        item = i - 1
        while (item >= 0 && arr[item] > temp) {
            arr[item + 1] = arr[item];
            arr[item] = temp;
            item--;
        }
    }
}

fun calculate(arr: IntArray) {
    var count = 0
    for (i in 0 until arr.size) {
        if (arr[i] in 10..20) count++;
    }
    println("Кількість чисел у діапазоні [10;20]: $count")
}

fun linearSearch(array: IntArray, key:Int) : Int {
    for (i in 0 until array.size) {
        if (array[i] == key) return i
    }
    return -1
}

fun findBinaryAndCalculate(a: IntArray, num: Int): Pair<Int,Int> {
    var count = 0
    var lo = 0
    var hi = a.size - 1
    var mid = -1
    while (true) {
        mid = (lo + hi) / 2
        if (a[mid] == num) {
            break
        }
        if (lo > hi) {
            mid = -1;
            break
        }
        if (a[mid] < num) {
            count++
            lo = mid + 1
        } else {
            count++
            hi = mid - 1
        }
    }
    return Pair(mid,count)
}

/*fun findBinary(a: IntArray, num: Int): Int {
    var lo = 0
    var hi = a.size - 1
    while (true) {
        val mid = (lo + hi) / 2
        if (a[mid] == num) {
            return mid
        }
        if (lo > hi) {
            return -1
        }
        if (a[mid] < num) {
            lo = mid + 1
        } else {
            hi = mid - 1
        }
    }
}*/
