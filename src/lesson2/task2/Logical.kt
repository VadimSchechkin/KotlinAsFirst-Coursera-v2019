@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.*

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val numberStr: String = number.toString()
    return when {
        numberStr[0].toInt() + numberStr[1].toInt() == numberStr[2].toInt() + numberStr[3].toInt() -> true
        else -> false
    }
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    return when {
        x1 == x2 || y1 == y2 -> true
        x1 + y1 == x2 + y2 -> true
        x1 - y1 == x2 - y2 -> true
        else -> false
    }
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    var leapYear = false
    leapYear = when {
        year % 400 == 0 -> true
        year % 100 == 0 -> false
        year % 4 == 0 -> true
        else -> false
    }

    return when {
        month == 1 -> 31
        month == 2 && leapYear -> 29
        month == 2 && !leapYear -> 28
        month == 3 -> 31
        month == 4 -> 30
        month == 5 -> 31
        month == 6 -> 30
        month == 7 -> 31
        month == 8 -> 31
        month == 9 -> 30
        month == 10 -> 31
        month == 11 -> 30
        else -> 31
    }
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    var length = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))
    return when {
        r2 >= length + r1 -> true
        else -> false
    }
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    return when {
        (a <= r || b <= r || c <= r) && (a <= s || b <= s || c <= s) -> true
        else -> false
    }
}
