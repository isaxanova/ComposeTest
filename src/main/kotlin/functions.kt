fun main() {
    myfunction()
    myfunction()
    myfunction()
    var value = hardCalculation()
    println("значение равнно $value ")
    println("наша функция вернула: ${getGreeting()}")
    var resalt1 = summ(5, 2)
    println("сумма1=$resalt1")
    println("${max(8, 15)}")
    println("${max(param1 = 800, param2 = 115)}")
}

fun myfunction() {
    println("функция была вызвана")
}

fun hardCalculation(): Int {
    return 6
}

fun getGreeting(): String {
    return "поздравляем"
}

fun summ(a: Int, b: Int): Int {
    var результат_суммы = a / b
    return a
}

fun max(param1: Int, param2: Int): Int {
    if (param1 > param2) {
        return param1
    } else {
        return param2
    }
}